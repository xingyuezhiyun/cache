package com.xingyuezhiyun.cache.local;

import com.xingyuezhiyun.cache.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCache;

public class LocalCache<T> implements Cache<T> {

    CaffeineCache caffeineCache;

    @Override
    public String getString(String key) {
        return null;
    }

    @Override
    public void setString(String key, String value) {

    }

    @Override
    public void setString(String key, String value, int expire) {

    }

    @Override
    public T get(String key) {
        return null;
    }


    @Override
    public void set(String key, Object o) {

    }

    @Override
    public void set(String key, Object o, int expire) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public Long incr(String key) {
        return 0L;
    }

    @Override
    public Long incr(String key, Long value) {
        return 0L;
    }
}
