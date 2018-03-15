package com.vcg.chat.sample.controller;

import com.vcg.chat.api.PushApi;
import com.vcg.chat.api.UserApi;
import com.vcg.chat.api.UserDialogueApi;
import com.vcg.chat.api.model.Request;
import com.vcg.chat.api.model.User;
import com.vcg.chat.logic.model.PriMessage;
import com.vcg.chat.logic.model.UserDialogue;
import com.vcg.chat.sample.model.PriMessageDTO;
import com.vcg.chat.sample.model.UserDialogueDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * created by wuyu on 2018/3/13
 */
@RestController
@RequestMapping(value = "chat")
public class ChatController {

    @Autowired
    private UserDialogueApi userDialogueApi;

    @Autowired
    private PushApi pushApi;

    @Autowired
    private UserApi userApi;

    private static final String TEMP_DIR = System.getProperty("java.io.tmpdir");

    /**
     * 上传文件用于测试图片、视频、音频消息,线上请使用s3 或 oss
     *
     * @param toUserId   对方id
     * @param dialogueId 对话id
     * @param file       文件
     * @return
     */
    @PostMapping(value = "upload")
    public void upload(@RequestParam(value = "toUserId") String toUserId,
                       @RequestParam(value = "dialogueId") Long dialogueId,
                       @RequestParam(value = "file") MultipartFile file) throws IOException {
        File transferFile = new File(TEMP_DIR + "/" + file.getOriginalFilename());
        file.transferTo(transferFile);
        String currentUserId = getCurrentUserId();

        PriMessage priMessage = new PriMessage()
                .setSendId(currentUserId)
                .setRecId(toUserId)
                .setDialogueId(dialogueId)
                .setType(0)
                .setMessage("/storage/" + transferFile.getName());

        // 简单判断 消息类型 0 普通消息 1 图片消息 2 语音消息  3 视频消息 4 实时语音消息 5 实时视频消息
        if (file.getOriginalFilename().contains(".mp4")) {
            priMessage.setMessageType(2);
        } else {
            priMessage.setMessageType(1);
        }
        userDialogueApi.sendMessage(priMessage);
    }

    /**
     * 在线用户
     *
     * @return List<User> 所有在线用户
     */
    @GetMapping(value = "onlineUsers")
    public List<User> onlineUsers() {
        return pushApi.onlineUsers()
                .stream()
                .map(k -> userApi.findNicknameAndAvatarAndIdById(Long.valueOf(k)))
                .collect(Collectors.toList());
    }

    /**
     * 查询用户头像，昵称
     */
    @GetMapping(value = "findNicknameAndAvatarAndIdById/{id}")
    public User findNicknameAndAvatarAndIdById(@PathVariable(value = "id") Long id) {
        return userApi.findNicknameAndAvatarAndIdById(id);
    }


    /**
     * 推送消息，不入库。仅测试
     */
    @PostMapping(value = "push")
    void push(@RequestBody Request request) {
        pushApi.multiPush(request);
    }

    /**
     * 发送消息
     *
     * @param priMessage
     */
    @ApiOperation(value = "发送消息")
    @PostMapping(value = "sendMessage")
    void sendMessage(@RequestBody PriMessage priMessage) {
        //当前登陆用户
        String userId = getCurrentUserId();
        priMessage.setSendId(userId);
        userDialogueApi.sendMessage(priMessage);
    }

    /**
     * 创建对话
     *
     * @param userDialogue
     */
    @ApiOperation(value = "创建对话")
    @PostMapping(value = "createDialogue")
    UserDialogue createDialogue(@RequestBody UserDialogue userDialogue) {
        userDialogue.setUserId(getCurrentUserId());
        return userDialogueApi.createDialogue(userDialogue);
    }


    /**
     * 更新对话
     *
     * @param userDialogue
     */
    @ApiOperation(value = "更新对话")
    @PutMapping(value = "updateDialogue")
    void updateDialogue(@RequestBody UserDialogue userDialogue) {
        userDialogueApi.updateDialogue(userDialogue);
    }

    /**
     * 查询对话
     *
     * @param dialogueId 对话id
     * @return
     */
    @ApiOperation(value = "查询对话")
    @GetMapping(value = "getDialogue/{dialogueId}")
    UserDialogue getDialogue(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        return userDialogueApi.getDialogue(dialogueId);
    }


    /**
     * 获取对话列表
     *
     * @param startNum 起始位
     * @param size     取多少条
     * @return
     */
    @ApiOperation(value = "获取对话列表")
    @GetMapping(value = "listUserDialogueByUserId")
    List<UserDialogueDTO> listUserDialogueByUserId(@ApiParam(value = "起始位") @Min(value = 0) @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                                   @ApiParam(value = "取多少条") @Max(value = 100) @RequestParam(value = "size", defaultValue = "10") Integer size) {

        //当前登陆用户
        String userId = getCurrentUserId();
        return userDialogueApi.listUserDialogueByUserId(userId, startNum, size)
                .stream()
                .map(u -> {
                    User user = userApi.findNicknameAndAvatarAndIdById(Long.valueOf(u.getToUserId()));
                    return new UserDialogueDTO()
                            .setUser(user)
                            .setUserDialogue(u);
                }).collect(Collectors.toList());
    }

    /**
     * @param parentId 父对话id
     * @param startNum 起始位
     * @param size     取多少条
     * @return
     */
    @ApiOperation(value = "获取对话列表")
    @GetMapping(value = "listUserDialogueByParentId/{parentId}")
    List<UserDialogue> listUserDialogueByParentId(@ApiParam(value = "父对话id") @PathVariable(value = "parentId") Long parentId,
                                                  @ApiParam(value = "起始位") @Min(value = 0) @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                                  @ApiParam(value = "取多少条") @Max(value = 100) @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return userDialogueApi.listUserDialogueByParentId(getCurrentUserId(), parentId, startNum, size);
    }

    /**
     * 对话消息列表
     *
     * @param toUserId   好友id
     * @param dialogueId 对话id
     * @param startNum   起始位
     * @param size       取多少条
     * @return
     */
    @ApiOperation(value = "对话消息列表")
    @GetMapping(value = "listPriMessageByDialogueId/{dialogueId}")
    PriMessageDTO listPriMessageByDialogueId(@ApiParam(value = "好友id") String toUserId,
                                             @ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId,
                                             @ApiParam(value = "起始位") @Min(value = 0) @RequestParam(value = "startNum", defaultValue = "0") Integer startNum,
                                             @ApiParam(value = "取多少条") @Max(value = 100) @RequestParam(value = "size", defaultValue = "10") Integer size) {
        String currentUserId = getCurrentUserId();
        User currentUser = findNicknameAndAvatarAndIdById(Long.valueOf(currentUserId));
        User toUser = findNicknameAndAvatarAndIdById(Long.valueOf(toUserId));
        List<PriMessage> priMessages = userDialogueApi.listPriMessageByDialogueId(currentUserId, dialogueId, startNum, size);
        return new PriMessageDTO()
                .setUser(currentUser)
                .setToUser(toUser)
                .setPriMessages(priMessages);
    }

    /**
     * 统计未读数量
     *
     * @param userId 用户id
     * @return
     */
    @ApiOperation(value = "统计未读数量")
    @GetMapping(value = "getUserUnreadTotal/{userId}")
    Integer getUserUnreadTotal(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId) {
        return userDialogueApi.getUserUnreadTotal(userId);
    }

    /**
     * 消息置顶
     *
     * @param dialogueId 对话id
     */
    @ApiOperation(value = "消息置顶")
    @PutMapping(value = "listUserDialogueByUserId/{dialogueId}")
    void makeTop(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        userDialogueApi.makeTop(getCurrentUserId(), dialogueId);
    }

    /**
     * 删除对话并删除消息
     *
     * @param dialogueId 对话id
     * @return 删除条数
     */
    @ApiOperation(value = "删除对话并删除消息")
    @DeleteMapping(value = "deleteDialogue/{dialogueId}")
    void deleteDialogue(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        userDialogueApi.deleteDialogue(getCurrentUserId(), dialogueId);
    }

    /**
     * 设置对话已读
     *
     * @param dialogueId 对话id
     */
    @ApiOperation(value = "设置对话已读")
    @PutMapping(value = "readMessage/{dialogueId}")
    void readMessage(@ApiParam(value = "对话id") @PathVariable(value = "dialogueId") Long dialogueId) {
        userDialogueApi.readMessage(getCurrentUserId(), dialogueId);
    }

    /**
     * 设置所有对话已读
     *
     * @param userId 用户id
     * @return
     */
    @ApiOperation(value = "设置所有对话已读")
    @PutMapping(value = "readAll/{userId}")
    void readAll(@ApiParam(value = "用户id") @PathVariable(value = "userId") String userId) {
        userDialogueApi.readAll(userId);
    }

    public static String getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            if (authentication instanceof OAuth2Authentication) {
                OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
                Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
                if (userAuthentication != null) {
                    Object details = userAuthentication.getDetails();
                    if (details != null && details instanceof Map) {
                        Map<String, Object> m = (Map<String, Object>) details;
                        return m.get("id").toString();

                    }
                }
            }
        }
        return null;
    }
}
