package com.vcg.chat.server.store;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * created by wuyu on 2016/3/1
 */
public class RedisStore implements Store {

    private StringRedisTemplate stringRedisTemplate;

    public RedisStore(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void del(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public long hincrBy(String key, String field, long value) {
        return stringRedisTemplate.opsForHash().increment(key, field, value);
    }

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }


    @Override
    public void set(String key, String value, int expireTime) {
        stringRedisTemplate.opsForValue().set(key, value, expireTime);
    }


    @Override
    public <T> T get(String key, Class<T> tClass) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if (value == null) {
            return null;
        }
        return JSON.parseObject(key, tClass);
    }

    @Override
    public void hset(String key, String field, String value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
    }


    @Override
    public <T> T hget(String key, String field, Class<T> tClass) {
        String value = (String) stringRedisTemplate.opsForHash().get(key, field);
        if (value == null) {
            return null;
        }
        return JSON.parseObject(value, tClass);
    }

    @Override
    public void hdel(String key, String field) {
        stringRedisTemplate.opsForHash().delete(key, field);
    }

    @Override
    public <T> Map<String, T> hgetAll(String key, Class<T> clazz) {
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
        Map<String, T> map = new HashMap<>(entries.size());
        for (Map.Entry<Object, Object> entry : entries.entrySet()) {
            T t = JSON.parseObject(entry.getValue().toString(), clazz);
            map.put(entry.getKey().toString(), t);
        }

        return map;
    }

    @Override
    public Set<String> keys(String prefix) {
        return stringRedisTemplate.keys(prefix);
    }


}
