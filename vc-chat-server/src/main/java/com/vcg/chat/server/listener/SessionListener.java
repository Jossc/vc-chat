package com.vcg.chat.server.listener;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.vcg.chat.server.filter.Filter;
import com.vcg.chat.server.router.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.serviceregistry.Registration;

import java.net.InetAddress;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * created by wuyu on 2018/2/27
 */
@Slf4j
public class SessionListener implements ConnectListener, DisconnectListener {

    private List<Filter> filters = new CopyOnWriteArrayList<>();

    private LocalRouterManager localRouterManager;

    private RemoteRouterManager remoteRouterManager;

    private Registration registration;

    public SessionListener( Registration registration,
                           LocalRouterManager localRouterManager,
                           RemoteRouterManager remoteRouterManager) {
        this.registration = registration;
        this.localRouterManager = localRouterManager;
        this.remoteRouterManager = remoteRouterManager;
    }

    @Override
    public void onConnect(final SocketIOClient client) {
        for (Filter filter : filters) {
            if (!filter.invoke(client)) {
                client.disconnect();
                return;
            }
        }
        register(client);
    }

    @Override
    public void onDisconnect(SocketIOClient socketIOClient) {
        String key = getKey(socketIOClient);
        String sessionId = socketIOClient.getSessionId().toString();
        unregister(key, sessionId);
    }


    /**
     * 删除路由
     *
     * @param
     */
    public void unregister(String userId, String sessionId) {
        try {
            //注册本地路由
            this.remoteRouterManager.unRegister(userId, sessionId);
            //注册远程路由
            this.localRouterManager.unRegister(userId, sessionId);
        } catch (Exception e) {
            log.warn("unregister error", e);
        }
    }

    /**
     * 注册路由
     *
     * @param socketIOClient
     */
    public void register(SocketIOClient socketIOClient) {
        String sessionId = socketIOClient.getSessionId().toString();
        String clientType = getClientType(socketIOClient);
        String key = getKey(socketIOClient);
        try {

            ClientLocation clientLocation = new ClientLocation()
                    .setSessionId(sessionId)
                    .setHost(registration.getHost())
                    .setClientType(clientType)
                    .setPort(registration.getPort());
            //注册本地路由
            this.remoteRouterManager.register(key, new RemoteRouter(clientLocation));
            //注册远程路由
            this.localRouterManager.register(key, new LocalRouter(socketIOClient));
        } catch (Exception e) {
            this.localRouterManager.unRegister(key, sessionId);
            if (socketIOClient.isChannelOpen()) {
                socketIOClient.disconnect();
            }
            log.warn("register error", e);
        }
    }

    private String getClientType(SocketIOClient socketIOClient) {
        String clientType = socketIOClient.get("clientType");
        if (clientType != null) return clientType;
        clientType = socketIOClient.getHandshakeData().getSingleUrlParam("clientType");
        clientType = clientType == null ? "other" : clientType;
        socketIOClient.set("clientType", clientType);
        return clientType;
    }

    private String getKey(SocketIOClient socketIOClient) {
        String userId = socketIOClient.get("userId");
        if (userId == null) {
            userId = socketIOClient.getSessionId().toString();
        }
        return userId;
    }

    public void addFilters(List<Filter> filter) {
        filters.addAll(filter);
    }

}
