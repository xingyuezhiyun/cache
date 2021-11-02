package com.xingyuezhiyun.cache.cache;

/**
 * 缓存抽象通用接口
 *
 * @author xingyue
 */
public interface Cache<T> {

    String getString(String key);

    void setString(String key, String value);

    void setString(String key, String value, int expire);

    T get(String key);

    void set(String key, T t);

    void set(String key, T t, int expire);

    void delete(String key);

    Long incr(String key);

    Long incr(String key, Long value);

}
