package com.vcg.chat.api;

import com.vcg.chat.api.model.Request;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

/**
 * created by wuyu on 2018/3/1
 */
@FeignClient(value = "vc-chat-server", path = "/api/push")
@Api(value = "消息推送接口")
public interface PushApi {

    /**
     * 单机推送
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "单机推送")
    @PostMapping(value = "singlePush")
    void singlePush(@Validated @RequestBody Request request);


    /**
     * 多线路推送 一个用户可能连接到不同的机器上. 该方法 主要根据用户id 查询相关sessionId 进行转发调用
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "多线路推送")
    @PostMapping(value = "multiPush")
    void multiPush(@Validated @RequestBody Request request);


//    /**
//     * 该方法 主要根据用户id 进行推送.利用消息队列的 fanout 广播机制,
//     * 广播到每台机器上,每台机器直接用本地路由表进行推送避免消息二次转发
//     *
//     * @param request
//     * @return
//     */
//    @ApiOperation(value = "多线路推送")
//    @PostMapping(value = "mqPush")
//    void mqPush(@Validated @RequestBody Request request);

    @ApiOperation(value = "查询所有连接的用户")
    @GetMapping(value = "lookupAllUser")
    Set<String> onlineUsers();

}
