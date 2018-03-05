package com.vcg.chat.server.filter;

import com.corundumstudio.socketio.SocketIOClient;

/**
 * created by wuyu on 2018/2/27
 */
public interface Filter {

    boolean invoke(SocketIOClient socketIOClient);
}
