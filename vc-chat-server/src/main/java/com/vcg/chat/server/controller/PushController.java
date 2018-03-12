package com.vcg.chat.server.controller;

import com.vcg.chat.api.PushApi;
import com.vcg.chat.api.model.Request;
import com.vcg.chat.server.service.PushService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by wuyu on 2018/2/27
 */
@RestController
@RequestMapping(value = "/api/push")
@Api(value = "推送接口")
public class PushController implements PushApi {

    @Autowired
    private PushService pushService;

    @ApiOperation(value = "单机推送", notes = "需要userId + sessionid 进行推送")
    public void singlePush(@Validated @RequestBody Request request) {
        pushService.singlePush(request);
    }


    @ApiOperation(value = "多链路推送", notes = "需要用户id进行推送")
    public void multiPush(@Validated @RequestBody Request request) {
        pushService.multiPush(request);
    }

//    @ApiOperation(value = "多链路推送", notes = "需要用户id进行推送")
//    public void mqPush(@Validated @RequestBody Request request) {
//        amqpTemplate.convertAndSend(ExchangeTypes.FANOUT, QueueName.CHAT_BROADCAST_QUEUE_NAME, request);
//    }


}
