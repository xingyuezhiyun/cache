package com.xingyuezhiyun.cache.cache;

/**
 * 缓存服务创建接口
 */
public interface CacheService<T> {

    Cache<T> create(String server, String module);

    Cache<T> create(String server, String module, String func1, String... func2);

}
