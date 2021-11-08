package com.xingyuezhiyun.cache.local;

import com.xingyuezhiyun.cache.cache.AbstractCacheService;
import com.xingyuezhiyun.cache.cache.Cache;

/**
 * 本地缓存服务
 */
public class LocalService<T> extends AbstractCacheService<T> {

    @Override
    protected Cache<T> doCreateCache(String prefix) {
        return new LocalCache();
    }
}
