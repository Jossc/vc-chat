package com.vcg.chat.server.router;


import java.util.Map;
import java.util.Set;


public interface RouterManager<R extends Router> {

    /**
     * 注册路由
     *
     * @param userId
     * @param router
     * @return
     */
    R register(String userId, R router);

    /**
     * 删除路由
     *
     * @param userId
     * @param sessionId
     * @return
     */
    boolean unRegister(String userId, String sessionId);

    /**
     * 查询路由
     *
     * @param userId
     * @return
     */
    Set<R> lookupAll(String userId);

    /**
     * 查询路由
     *
     * @param userId
     * @param sessionId
     * @return
     */
    R lookup(String userId, String sessionId);


    /**
     * 在线用户
     *
     * @return
     */
    Set<String> onlineUsers();

    /**
     * 查询所有路由
     *
     * @return
     */
    Map<String, Map<String, R>> lookupAll();

}
