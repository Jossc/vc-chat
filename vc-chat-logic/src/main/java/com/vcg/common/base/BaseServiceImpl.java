package com.vcg.common.base;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;


public abstract class BaseServiceImpl<T, Q, P> implements BaseService<T, Q, P> {


    protected BaseDao<T, Q> baseDao;

    public abstract void setDao();

    private Class<?> type = null;

    private Class<?> example = null;


    public BaseServiceImpl() {
        if (type == null && !this.getClass().getName().contains("EnhancerBySpringCGLIB")) {
            if (this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
                ParameterizedType superGclass = (ParameterizedType) this.getClass().getGenericSuperclass();
                Type[] arguments = superGclass.getActualTypeArguments();

                if (arguments.length > 0) {
                    type = (Class<?>) arguments[0];
                    example = (Class<?>) arguments[1];
                }
            }
        }
    }


    @Transactional(readOnly = true)
    public T selectByPrimaryKey(P id) {
        setDao();
        return baseDao.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = true)
    public List<T> selectByPrimaryKeys(List<P> ids) {
        setDao();
        if (ids != null && ids.size() == 1) {
            return Arrays.asList(baseDao.selectByPrimaryKey(ids.get(0)));
        }
        return baseDao.selectByPrimaryKeys(ids);
    }

    @Transactional(readOnly = true)
    public List<T> selectByExample(Q example) {
        setDao();
        return baseDao.selectByExample(example);
    }

    @Transactional
    public Object insert(T t) {
        setDao();
        return baseDao.insert(t);
    }

    @Transactional
    public Object insertSelective(T t) {
        setDao();
        return baseDao.insertSelective(t);
    }

    @Transactional
    public void upsertSelective(T t) {
        setDao();
        baseDao.upsertSeletive(t);
    }

    @Transactional
    public Object insertBatch(List<T> ts) {
        setDao();
        baseDao.insertBatch(ts);
        return null;
    }

    @Transactional
    public Object updateByPrimaryKeySelective(T t) {
        setDao();
        return baseDao.updateByPrimaryKeySelective(t);
    }

    @Transactional
    public Object updateByExampleSelective(T t, Q q) {
        setDao();
        return baseDao.updateByExampleSelective(t, q);
    }

    @Transactional
    public Object updateByExample(T t, Q q) {
        setDao();
        return baseDao.updateByExample(t, q);
    }

    @Transactional
    public Object updateByPrimaryKey(T t) {
        setDao();
        return baseDao.updateByPrimaryKey(t);
    }

    @Transactional(readOnly = true)
    public Long countByExample(Q example) {
        setDao();
        return baseDao.countByExample(example);

    }

    @Transactional
    public void updateBatch(List<T> ts) {
        setDao();
        baseDao.updateBatch(ts);
    }

    @Transactional
    public Integer deleteByPrimaryKey(P id) {
        setDao();
        return baseDao.deleteByPrimaryKey(id);
    }

    @Transactional
    public Integer deleteByPrimaryKeys(List<P> ids) {
        setDao();
        return baseDao.deleteByPrimaryKeys(ids);
    }

    @Transactional
    public Integer deleteByExample(Q q) {
        setDao();
        return baseDao.deleteByExample(q);
    }

}
