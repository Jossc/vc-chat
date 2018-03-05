package com.vcg.chat.server.filter;

import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOClient;
import com.vcg.chat.server.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * created by wuyu on 2018/2/27
 */
@Slf4j
public class AuthFilter implements Filter {

    @Override
    public boolean invoke(SocketIOClient socketIOClient) {
//        HandshakeData handshakeData = socketIOClient.getHandshakeData();
//        String access_token = handshakeData.getSingleUrlParam("accessToken");
//        try {
//            if (StringUtils.isEmpty(access_token)) return false;
//            Claims claims = JwtUtil.unsign(access_token);
//            String subject = claims.getSubject();
//            Date expiration = claims.getExpiration();
//            if (expiration.getTime() > System.currentTimeMillis()) {
//                socketIOClient.set("user", claims);
//                socketIOClient.set("userId", subject);
//                return true;
//            }
//        } catch (Exception e) {
//            log.warn("authentication failed!", e);
//        }
        socketIOClient.set("userId", "1");

        return true;
    }

}
