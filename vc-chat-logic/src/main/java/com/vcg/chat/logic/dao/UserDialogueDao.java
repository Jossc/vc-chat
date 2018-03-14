package com.vcg.chat.logic.dao;

import com.vcg.chat.logic.model.UserDialogue;
import com.vcg.chat.logic.model.query.UserDialogueExample;
import com.vcg.common.base.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * Created on 2018/2/26 22:19.
 */
public interface UserDialogueDao extends BaseDao<UserDialogue, UserDialogueExample> {

    /**
     * 统计用户未读数量
     *
     * @param userId 用户id
     * @return
     */
    @Select(value = "select ifnull(sum(unread_total),0) from user_dialogue where user_id = #{userId} and unread_total>0 and parent_id=0")
    int sumUserUnreadTotal(@Param("userId") String userId);

    /**
     * 统计父对话的所有未读数
     *
     * @param parentId
     * @return
     */
    @Select(value = " select  ifnull(sum(unread_total),0) from user_dialogue where parent_id = #{parentId} and unread_total>0 and user_id=#{userId}")
    int sumParentDialogueUnreadTotal(@Param(value = "userId") String userId, @Param("parentId") Long parentId);

}