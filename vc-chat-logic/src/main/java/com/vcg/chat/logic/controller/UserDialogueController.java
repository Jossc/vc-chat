package com.vcg.chat.logic.controller;

import com.vcg.chat.api.UserDialogueApi;
import com.vcg.chat.logic.model.PriMessage;
import com.vcg.chat.logic.model.UserDialogue;
import com.vcg.chat.logic.service.UserDialogueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * created by wuyu on 2018/3/5
 */
@RequestMapping(value = "/api/userDialogue")
@RestController
@Api(value = "消息接口")
public class UserDialogueController implements UserDialogueApi {

    @Autowired
    private UserDialogueService userDialogueService;

    /**
     * 插入消息
     *
     * @param priMessage
     */
    public void sendMessage(@RequestBody PriMessage priMessage) {
        userDialogueService.insertMessage(priMessage);
    }

    /**
     * 创建对话
     *
     * @param userDialogue
     * @return
     */
    @Override
    public UserDialogue createDialogue(@RequestBody UserDialogue userDialogue) {
        return userDialogueService.createDialogue(userDialogue);
    }

    /**
     * 更新对话
     *
     * @param userDialogue
     */
    public void updateDialogue(@RequestBody UserDialogue userDialogue) {
        userDialogueService.updateByPrimaryKeySelective(userDialogue);
    }

    /**
     * 查询对话
     *
     * @param dialogueId 对话id
     * @return
     */
    public UserDialogue getDialogue(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        return userDialogueService.selectByPrimaryKey(dialogueId);
    }


    /**
     * @param userId   用户id
     * @param startNum 起始位
     * @param size     取多少条
     * @return
     */
    public List<UserDialogue> listUserDialogueByUserId(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId,
                                                       @ApiParam(value = "起始位") @Min(value = 0) @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                                       @ApiParam(value = "取多少条") @Max(value = 100) @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return userDialogueService.listUserDialogueByUserId(userId, startNum, size);
    }

    /**
     * @param parentId 父对话id
     * @param startNum 起始位
     * @param size     取多少条
     * @return
     */
    public List<UserDialogue> listUserDialogueByParentId(@ApiParam(value = "父对话id") @PathVariable(value = "parentId") Long parentId,
                                                         @ApiParam(value = "起始位") @Min(value = 0) @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                                         @ApiParam(value = "取多少条") @Max(value = 100) @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return userDialogueService.listUserDialogueByParentId(parentId, startNum, size);
    }

    /**
     * @param dialogueId 对话id
     * @param startNum   起始位
     * @param size       取多少条
     * @return
     */
    public List<PriMessage> listPriMessageByDialogueId(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId,
                                                       @ApiParam(value = "起始位") @Min(value = 0) @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                                       @ApiParam(value = "取多少条") @Max(value = 100) @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return userDialogueService.listPriMessageByDialogueId(dialogueId, startNum, size);
    }

    /**
     * 统计未读数量
     *
     * @param userId 用户id
     * @return
     */
    public Integer getUserUnreadTotal(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId) {
        return userDialogueService.sumUserUnreadTotal(userId);
    }

    /**
     * 置顶
     *
     * @param dialogueId 对话id
     */
    public void makeTop(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        userDialogueService.makeTop(dialogueId);
    }

    /**
     * 删除对话并删除消息
     *
     * @param dialogueId 对话id
     * @return 删除条数
     */
    public void deleteDialogue(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        userDialogueService.deleteDialogue(dialogueId);
    }

    /**
     * 设置对话已读
     *
     * @param dialogueId 对话id
     */
    public void readMessage(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        userDialogueService.readMessage(dialogueId);
    }

    /**
     * 设置所有对话已读
     *
     * @param userId 用户id
     * @return
     */
    public void readAll(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId) {
        userDialogueService.readAll(userId);
    }


}
