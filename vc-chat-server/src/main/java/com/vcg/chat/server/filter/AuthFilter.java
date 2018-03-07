package com.vcg.chat.server.filter;

import com.corundumstudio.socketio.HandshakeData;
import com.corundumstudio.socketio.SocketIOClient;
import com.vcg.chat.api.model.User;
import com.vcg.chat.server.config.ChatProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

/**
 * created by wuyu on 2018/2/27
 */
@Slf4j
public class AuthFilter implements Filter {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChatProperties chatProperties;

    @Override
    public boolean invoke(SocketIOClient socketIOClient) {
        HandshakeData handshakeData = socketIOClient.getHandshakeData();
        String accessToken = handshakeData.getSingleUrlParam("accessToken");
        try {
            if (StringUtils.isEmpty(accessToken)) {
                accessToken = handshakeData.getHttpHeaders().get("Authorization");
            }
            if (!StringUtils.isEmpty(accessToken)) {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization", "Bearer " + accessToken);
                ResponseEntity<User> userResponseEntity = restTemplate.exchange(chatProperties.getOauth2().getUserInfoUrl(),
                        GET,
                        new HttpEntity(headers),
                        User.class);

                if (userResponseEntity.getStatusCode().is2xxSuccessful()) {
                    User user = userResponseEntity.getBody();
                    if (user != null && !StringUtils.isEmpty(user.getId())) {
                        socketIOClient.set("userId", user.getId());
                        socketIOClient.set("user", user);
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            if (socketIOClient.isChannelOpen()) {
                socketIOClient.disconnect();
            }
            log.warn("Invalid access token: {}", accessToken);
        }
        return false;
    }

}
