package com.vcg.chat.logic.service;

import com.vcg.chat.api.PushApi;
import com.vcg.chat.api.model.Request;
import com.vcg.chat.logic.dao.PriMessageDao;
import com.vcg.chat.logic.dao.SystemMessageDao;
import com.vcg.chat.logic.dao.UserDialogueDao;
import com.vcg.chat.logic.dao.UserSystemMessageDao;
import com.vcg.chat.logic.model.PriMessage;
import com.vcg.chat.logic.model.SystemMessage;
import com.vcg.chat.logic.model.UserDialogue;
import com.vcg.chat.logic.model.UserSystemMessage;
import com.vcg.chat.logic.model.query.PriMessageExample;
import com.vcg.chat.logic.model.query.SystemMessageExample;
import com.vcg.chat.logic.model.query.UserDialogueExample;
import com.vcg.chat.logic.model.query.UserSystemMessageExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 2017/2/15 15:54.
 */
@Service
@Slf4j
public class UserDialogueService {

    @Autowired
    private UserDialogueDao userDialogueDao;

    @Autowired
    private PriMessageDao priMessageDao;

    @Autowired
    private UserSystemMessageDao userSystemMessageDao;

    @Autowired
    private SystemMessageDao systemMessageDao;

    @Autowired
    private PushApi pushApi;

    /**
     * 插入消息
     *
     * @param priMessage
     */
    @Transactional
    public void insertMessage(PriMessage priMessage) {

        String sendId = priMessage.getSendId();
        String recId = priMessage.getRecId();

        //创建时间
        Date currentTime = new Date();
        String message = priMessage.getMessage();
        Integer type = priMessage.getType();

        //双方产生唯一id
        String sendUniId = DigestUtils.md5Hex((sendId + "_" + recId));
        String recUniId = DigestUtils.md5Hex((recId + "_" + sendId));

        priMessage.setCreatedTime(currentTime);

        UserDialogue sendDialogue = new UserDialogue()
                .setUserId(sendId)
                .setToUserId(recId)
                .setLastMessage(message)
                .setOrdered(currentTime.getTime())
                .setUniId(sendUniId)
                .setUpdatedTime(currentTime)
                .setCreatedTime(currentTime)
                .setType(type);

        //接收人对话
        UserDialogue recDialogue = new UserDialogue()
                .setUserId(recId)
                .setToUserId(sendId)
                .setLastMessage(message)
                .setOrdered(currentTime.getTime())
                .setUnreadTotal(1)
                .setUniId(recUniId)
                .setUpdatedTime(currentTime)
                .setCreatedTime(currentTime)
                .setType(type);

        priMessageDao.upsertSeletive(priMessage);
        userDialogueDao.upsertSeletive(sendDialogue);
        userDialogueDao.upsertSeletive(recDialogue);

        push(recId, recDialogue);
        push(sendId, sendDialogue);

    }

    /**
     * 更新对话
     *
     * @param userDialogue
     */
    @Transactional
    public void updateByPrimaryKeySelective(UserDialogue userDialogue) {
        userDialogueDao.updateByPrimaryKeySelective(userDialogue);
    }

    /**
     * 查询对话
     *
     * @param dialogueId 对话id
     * @return
     */
    @Transactional(readOnly = true)
    public UserDialogue selectByPrimaryKey(Long dialogueId) {
        return userDialogueDao.selectByPrimaryKey(dialogueId);
    }


    /**
     * @param userId   用户id
     * @param startNum 起始位
     * @param size     取多少条
     * @return
     */
    @Transactional(readOnly = true)
    public List<UserDialogue> listUserDialogueByUserId(String userId, Integer startNum, Integer size) {
        return userDialogueDao.selectByExample(new UserDialogueExample()
                .withLimit(startNum, size)
                .withOrderByClause(UserDialogueExample.ordered + " desc")
                .addCriteria(
                        UserDialogueExample.newCriteria().andUserIdEqualTo(userId)
                ))
                .stream()
                .peek(u -> {
                    //判断本身是不是父对话,如果是查询本对话的所有子对话的未读数量
                    if (u.getParentMake() != null && u.getParentMake() == 1) {
                        Integer parentUnreadTotal = sumParentDialogueUnreadTotal(u.getId());
                        u.setUnreadTotal(parentUnreadTotal);
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * @param parentId 父对话id
     * @param startNum 起始位
     * @param size     取多少条
     * @return
     */
    @Transactional(readOnly = true)
    public List<UserDialogue> listUserDialogueByParentId(Long parentId, Integer startNum, Integer size) {
        return userDialogueDao.selectByExample(new UserDialogueExample()
                .withLimit(startNum, size)
                .withOrderByClause(UserDialogueExample.ordered + " desc")
                .addCriteria(
                        UserDialogueExample.newCriteria().andParentIdEqualTo(parentId)
                ))
                .stream()
                .peek(u -> {
                    //判断本身是不是父对话,如果是查询本对话的所有子对话的未读数量
                    if (u.getParentMake() != null && u.getParentMake() == 1) {
                        Integer parentUnreadTotal = sumParentDialogueUnreadTotal(u.getId());
                        u.setUnreadTotal(parentUnreadTotal);
                    }
                })
                .collect(Collectors.toList());
    }

    /**
     * @param dialogueId 对话id
     * @param startNum   起始位
     * @param size       取多少条
     * @return
     */
    @Transactional(readOnly = true)
    public List<PriMessage> listPriMessageByDialogueId(Long dialogueId, Integer startNum, Integer size) {
        return priMessageDao.selectByExample(new PriMessageExample()
                .withLimit(startNum, size)
                .withOrderByClause(PriMessageExample.id + " desc")
                .addCriteria(
                        PriMessageExample.newCriteria().andDialogueIdEqualTo(dialogueId)
                )
        );
    }

    /**
     * 统计未读数量
     *
     * @param userId 用户id
     * @return
     */
    @Transactional(readOnly = true)
    public Integer sumUserUnreadTotal(String userId) {
        int systemMessageUnreadTotal = getUserUnreadSystemMessageTotal(userId);
        return userDialogueDao.sumUserUnreadTotal(userId) + systemMessageUnreadTotal;
    }

    /**
     * 统计父对话的消息数
     *
     * @param parentDialogueId 父对话id
     * @return
     */
    @Transactional(readOnly = true)
    public Integer sumParentDialogueUnreadTotal(Long parentDialogueId) {
        return userDialogueDao.sumParentDialogueUnreadTotal(parentDialogueId);
    }

    /**
     * 置顶
     *
     * @param dialogueId 对话id
     */
    @Transactional
    public void makeTop(Long dialogueId) {
        UserDialogue userDialogue = new UserDialogue()
                .setOrdered(System.currentTimeMillis() * 10)
                .setId(dialogueId);
        userDialogueDao.updateByPrimaryKeySelective(userDialogue);
    }

    /**
     * 删除对话并删除消息
     *
     * @param dialogueId 对话id
     * @return 删除条数
     */
    @Transactional
    public int deleteDialogue(Long dialogueId) {
        userDialogueDao.deleteByPrimaryKey(dialogueId);
        PriMessageExample query = new PriMessageExample();
        query.createCriteria().andDialogueIdEqualTo(dialogueId);
        return priMessageDao.deleteByExample(query);
    }

    /**
     * 设置对话已读
     *
     * @param dialogueId 对话id
     */
    @Transactional
    public void readMessage(Long dialogueId) {
        userDialogueDao.updateByPrimaryKeySelective(new UserDialogue()
                .setId(dialogueId)
                .setUnreadTotal(0)
        );
    }

    /**
     * 设置所有对话已读
     *
     * @param userId 用户id
     * @return 已读消息数量
     */
    @Transactional
    public int readAll(String userId) {
        UserDialogue userDialogue = new UserDialogue()
                .setUnreadTotal(0);
        UserDialogueExample query = new UserDialogueExample();
        query.createCriteria().andUserIdEqualTo(userId);
        return userDialogueDao.updateByExampleSelective(userDialogue, query);
    }

    /**
     * 创建对话
     *
     * @param userDialogue
     * @return
     */
    @Transactional
    public UserDialogue createDialogue(UserDialogue userDialogue) {
        String userId = userDialogue.getUserId();
        String toUserId = userDialogue.getToUserId();
        String uniId = DigestUtils.md5Hex((userId + ":" + toUserId));
        Date createdTime = new Date();
        userDialogue.setCreatedTime(createdTime)
                .setUniId(uniId)
                .setUnreadTotal(0);
        userDialogueDao.upsertSeletive(userDialogue);
        return userDialogue;
    }


    /**
     * 检查用户广播消息
     *
     * @param userId 用户id
     * @return 广播消息数量
     */
    public int getUserUnreadSystemMessageTotal(String userId) {
        Long userLastSystemId = getUserLastSystemId(userId);
        SystemMessage lastSystemMessage = getLastSystemMessage();
        if (lastSystemMessage == null) {
            return 0;
        }

        if (lastSystemMessage.getId().intValue() != userLastSystemId.intValue()) {

            SystemMessageExample query = new SystemMessageExample();
            query.createCriteria().andIdGreaterThan(userLastSystemId);
            List<SystemMessage> systemMessages = systemMessageDao.selectByExample(query);
            for (SystemMessage systemMessage : systemMessages) {
                PriMessage priMessage = new PriMessage()
                        .setSendId(systemMessage.getSendId())
                        .setType(systemMessage.getType())
                        .setMessage(systemMessage.getMessage())
                        .setCreatedTime(systemMessage.getCreatedTime())
                        .setRecId(userId);

                insertMessage(priMessage);

                UserSystemMessage userSystemMessage = new UserSystemMessage()
                        .setCreatedTime(new Date())
                        .setSystemMessageId(systemMessage.getId())
                        .setUniId(DigestUtils.md5Hex(userId + "_" + systemMessage.getId()))
                        .setUserId(userId);
                userSystemMessageDao.insertSelective(userSystemMessage);
            }

            return systemMessages.size();
        }

        return 0;
    }

    /**
     * 获取用户最后一条接受的系统消息id
     *
     * @param userId 用户id
     * @return 系统消息id
     */
    public Long getUserLastSystemId(String userId) {
        UserSystemMessageExample query = new UserSystemMessageExample()
                .addCriteria(UserSystemMessageExample.newCriteria().andUserIdEqualTo(userId))
                .withOrderByClause(UserSystemMessageExample.id + " desc")
                .withLimit(1);
        List<UserSystemMessage> userSystemMessages = userSystemMessageDao.selectByExample(query);
        return userSystemMessages.size() > 0 ? userSystemMessages.get(0).getSystemMessageId() : 0;
    }


    /**
     * 获取最后一条系统广播消息
     *
     * @return 最后一条广播消息
     */
    public SystemMessage getLastSystemMessage() {
        SystemMessageExample query = new SystemMessageExample()
                .withOrderByClause(SystemMessageExample.id + " desc")
                .withLimit(1);
        List<SystemMessage> systemMessages = systemMessageDao.selectByExample(query);
        return systemMessages.size() > 0 ? systemMessages.get(0) : null;
    }


    public void push(String userId, UserDialogue userDialogue) {
        Request request = new Request()
                .setUserId(userId)
                .setData(userDialogue)
                .setCreatedTime(userDialogue.getCreatedTime());
        pushApi.multiPush(request);
    }

}