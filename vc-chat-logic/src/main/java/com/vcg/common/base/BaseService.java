package com.vcg.common.base;

import java.util.List;


public interface BaseService<T, Q, P> {


    T selectByPrimaryKey(P id);

    List<T> selectByPrimaryKeys(List<P> ids);

    List<T> selectByExample(Q example);

    Object insert(T t);

    Object insertSelective(T t);

    void upsertSelective(T t);

    Object insertBatch(List<T> models);

    Object updateByPrimaryKey(T t);

    Object updateByPrimaryKeySelective(T t);

    Object updateByExample(T t, Q q);

    Object updateByExampleSelective(T t, Q q);

    void updateBatch(List<T> ts);

    Long countByExample(Q example);

    Integer deleteByPrimaryKey(P id);

    Integer deleteByPrimaryKeys(List<P> ids);

    Integer deleteByExample(Q q);

}
