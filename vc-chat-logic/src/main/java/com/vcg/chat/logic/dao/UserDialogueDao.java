package com.vcg.chat.logic.dao;

import com.vcg.chat.logic.model.UserDialogue;
import com.vcg.chat.logic.model.query.UserDialogueExample;
import com.vcg.common.base.BaseDao;
import org.apache.ibatis.annotations.Param;

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
    Integer sumUserUnreadTotal(@Param("userId") String userId);

    /**
     * 统计父对话的所有未读数
     *
     * @param parentId
     * @return
     */
    Integer sumParentDialogueUnreadTotal(@Param("parentId") Long parentId);

}