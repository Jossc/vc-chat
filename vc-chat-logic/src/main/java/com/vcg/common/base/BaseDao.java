package com.vcg.common.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BaseDao<T, Q> {

    T selectByPrimaryKey(Object id);

    List<T> selectByPrimaryKeys(@SuppressWarnings("rawtypes") List ids);

    List<T> selectByExample(Q q);

    int insert(T t);

    int insertSelective(T t);

    void upsertSeletive(T t);

    void insertBatch(List<T> ts);

    long countByExample(Q q);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    int updateByExampleSelective(@Param("record") T t, @Param("example") Q q);

    int updateByExample(@Param("record") T t, @Param("example") Q q);

    void updateBatch(List<T> ts);

    int deleteByPrimaryKey(Object id);

    int deleteByPrimaryKeys(List list);

    int deleteByExample(Q q);


}
