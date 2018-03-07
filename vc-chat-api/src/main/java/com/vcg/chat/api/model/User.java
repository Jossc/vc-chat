package com.vcg.chat.api.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Collection;

/**
 * created by wuyu on 2018/3/6
 */
@Data
@Accessors(chain = true)
@ToString
public class User {

    /**
     * 用户id 全部强制转换为string 类型
     */
    private String id;

    /**
     * 用户名
     */
    private String username;


    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 是否被禁用
     */
    private boolean enabled;

    /**
     * 用户权限
     */
    private Collection<Authorities> authorities;


}
