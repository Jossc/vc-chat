package com.vcg.chat.api;

import com.vcg.chat.api.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created by wuyu on 2018/3/13
 */
@FeignClient(value = "vc-chat-oauth2", path = "user")
public interface UserApi {

    @GetMapping(value = "findNicknameAndAvatarAndIdById/{id}")
    User findNicknameAndAvatarAndIdById(@PathVariable(value = "id") Long id);
}
