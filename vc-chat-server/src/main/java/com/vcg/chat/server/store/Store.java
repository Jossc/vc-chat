

package com.vcg.chat.server.store;

import java.util.Map;

public interface Store {

    void del(String key);

    long hincrBy(String key, String field, long value);

    void set(String key, String value);

    void set(String key, String value, int expireTime);

    <T> T get(String key, Class<T> tClass);

    void hset(String key, String field, String value);

    <T> T hget(String key, String field, Class<T> tClass);

    void hdel(String key, String field);

    <T> Map<String, T> hgetAll(String key, Class<T> clazz);

}
