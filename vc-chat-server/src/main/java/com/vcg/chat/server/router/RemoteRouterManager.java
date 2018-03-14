package com.vcg.chat.server.router;

import com.alibaba.fastjson.JSON;
import com.vcg.chat.server.store.Store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoteRouterManager implements RouterManager<RemoteRouter> {

    private Store store;

    private static final String PREFIX = "chat:users:";

    public RemoteRouterManager(Store store) {
        this.store = store;
    }

    @Override
    public RemoteRouter register(String userId, RemoteRouter router) {
        store.hset(PREFIX + userId, router.getRouteValue().getSessionId(), JSON.toJSONString(router));
        return router;
    }

    @Override
    public boolean unRegister(String userId, String sessionId) {
        store.hdel(PREFIX + userId, sessionId);
        return true;
    }

    @Override
    public Set<RemoteRouter> lookupAll(String userId) {
        Map<String, RemoteRouter> map = store.hgetAll(PREFIX + userId, RemoteRouter.class);
        return new HashSet<>(map.values());
    }

    @Override
    public RemoteRouter lookup(String userId, String sessionId) {
        return store.hget(PREFIX + userId, sessionId, RemoteRouter.class);
    }

    @Override
    public Set<String> onlineUsers() {
        return store.keys(PREFIX + "*")
                .stream()
                .map(k->k.replace(PREFIX,""))
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Map<String, RemoteRouter>> lookupAll() {
        Set<String> keys = store.keys(PREFIX + "*");
        Map<String, Map<String, RemoteRouter>> map = new HashMap<>();
        for (String key : keys) {
            Map<String, RemoteRouter> remoteRouterMap = store.hgetAll(key, RemoteRouter.class);
            map.put(key.replace(PREFIX, ""), remoteRouterMap);
        }
        return map;
    }
}
