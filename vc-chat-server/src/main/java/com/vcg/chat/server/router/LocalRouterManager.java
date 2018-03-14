package com.vcg.chat.server.router;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Slf4j
public final class LocalRouterManager implements RouterManager<LocalRouter> {

    /**
     * 本地路由表
     */
    private final Map<String, Map<String, LocalRouter>> routers = new ConcurrentHashMap<>();

    @Override
    public LocalRouter register(String userId, LocalRouter router) {
        log.info("register local router success userId={}, router={}", userId, router);
        return routers.computeIfAbsent(userId, s -> new ConcurrentHashMap<>()).put(router.getSessionId(), router);
    }

    @Override
    public boolean unRegister(String userId, String sessionId) {
        LocalRouter router = routers.getOrDefault(userId, new HashMap<>(1)).remove(sessionId);
        log.info("unRegister local router success userId={}, router={}", userId, router);
        return true;
    }

    @Override
    public Set<LocalRouter> lookupAll(String userId) {
        return new HashSet<>(routers.getOrDefault(userId, new HashMap<>(1)).values());
    }

    @Override
    public LocalRouter lookup(String userId, String sessionId) {
        LocalRouter router = routers.getOrDefault(userId, new HashMap<>()).get(sessionId);
        if(log.isDebugEnabled()){
            log.debug("lookup local router userId={}, router={}", userId, router);
        }
        return router;
    }

    @Override
    public Set<String> onlineUsers() {
        return new HashSet<>(routers.keySet());
    }

    @Override
    public Map<String, Map<String, LocalRouter>> lookupAll() {
        return Collections.unmodifiableMap(routers);
    }


}
