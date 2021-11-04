package com.xingyuezhiyun.cache.local;

import com.xingyuezhiyun.cache.cache.AbstractCacheService;
import com.xingyuezhiyun.cache.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCache;

/**
 * 本地缓存服务
 */
public class LocalService<T> extends AbstractCacheService<T> {

    /**
     * 获取到应用的信息,创建redis对象并提供服务
     */
    private String prefix;

    /**
     * 通过CaffeineCache接口提供服务
     */
    CaffeineCache caffeineCache;


    @Override
    protected Cache<T> doCreateCache(String key) {
        return null;
    }
}
