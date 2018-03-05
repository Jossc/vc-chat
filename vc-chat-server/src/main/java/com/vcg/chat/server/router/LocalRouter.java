package com.vcg.chat.server.router;

import com.corundumstudio.socketio.SocketIOClient;

public final class LocalRouter implements Router<SocketIOClient> {


    private final SocketIOClient socketIOClient;

    public LocalRouter(SocketIOClient socketIOClient) {
        this.socketIOClient = socketIOClient;
    }

    public String getSessionId() {
        return socketIOClient.getSessionId().toString();
    }

    @Override
    public SocketIOClient getRouteValue() {
        return socketIOClient;
    }

    public SocketIOClient getSocketIOClient() {
        return socketIOClient;
    }

    @Override
    public String toString() {
        return "LocalRouter{" + socketIOClient.getSessionId() + '}';
    }

}
