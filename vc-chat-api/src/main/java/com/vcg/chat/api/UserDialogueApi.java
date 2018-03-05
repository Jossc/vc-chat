package com.vcg.chat.api;

import com.vcg.chat.logic.model.PriMessage;
import com.vcg.chat.logic.model.UserDialogue;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * created by wuyu on 2018/3/5
 */
@FeignClient(value = "vc-chat-logic", path = "/api/userDialogue")
@Api(value = "消息接口")
public interface UserDialogueApi {

    /**
     * 发送消息
     *
     * @param priMessage
     */
    @ApiOperation(value = "发送消息")
    @PostMapping(value = "sendMessage")
    void sendMessage(@RequestBody PriMessage priMessage);


    /**
     * 更新对话
     *
     * @param userDialogue
     */
    @ApiOperation(value = "更新对话")
    @PutMapping(value = "updateDialogue")
    void updateDialogue(@RequestBody UserDialogue userDialogue);

    /**
     * 查询对话
     *
     * @param dialogueId 对话id
     * @return
     */
    @ApiOperation(value = "查询对话")
    @GetMapping(value = "getDialogue/{dialogueId}")
    UserDialogue getDialogue(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId);


    /**
     * 获取对话列表
     *
     * @param userId   用户id
     * @param startNum 起始位
     * @param size     取多少条
     * @return
     */
    @ApiOperation(value = "获取对话列表")
    @GetMapping(value = "listUserDialogueByUserId/{userId}")
    List<UserDialogue> listUserDialogueByUserId(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId,
                                                @ApiParam(value = "起始位") @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                                @ApiParam(value = "取多少条") @RequestParam(value = "size", defaultValue = "10") Integer size);

    /**
     * 对话消息列表
     *
     * @param dialogueId 对话id
     * @param startNum   起始位
     * @param size       取多少条
     * @return
     */
    @ApiOperation(value = "对话消息列表")
    @GetMapping(value = "listPriMessageByDialogueId/{dialogueId}")
    List<PriMessage> listPriMessageByDialogueId(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId,
                                                @ApiParam(value = "起始位") @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                                @ApiParam(value = "取多少条") @RequestParam(value = "size", defaultValue = "10") Integer size);

    /**
     * 统计未读数量
     *
     * @param userId 用户id
     * @return
     */
    @ApiOperation(value = "统计未读数量")
    @GetMapping(value = "getUserUnreadTotal/{userId}")
    Integer getUserUnreadTotal(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId);

    /**
     * 消息置顶
     *
     * @param dialogueId 对话id
     */
    @ApiOperation(value = "消息置顶")
    @PutMapping(value = "listUserDialogueByUserId/{dialogueId}")
    void makeTop(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId);

    /**
     * 删除对话并删除消息
     *
     * @param dialogueId 对话id
     * @return 删除条数
     */
    @ApiOperation(value = "删除对话并删除消息")
    @DeleteMapping(value = "deleteDialogue/{dialogueId}")
    void deleteDialogue(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId);

    /**
     * 设置对话已读
     *
     * @param dialogueId 对话id
     */
    @ApiOperation(value = "设置对话已读")
    @PutMapping(value = "readMessage/{dialogueId}")
    void readMessage(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId);

    /**
     * 设置所有对话已读
     *
     * @param userId 用户id
     * @return
     */
    @ApiOperation(value = "设置所有对话已读")
    @PutMapping(value = "readAll/{userId}")
    void readAll(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId);


}
