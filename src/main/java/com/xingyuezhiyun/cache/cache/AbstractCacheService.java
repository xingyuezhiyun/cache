package com.xingyuezhiyun.cache.cache;

/**
 * 适配接口抽象类,提供一些公共(抽象)方法
 */
public abstract class AbstractCacheService<T> implements CacheService<T> {

    @Override
    public Cache<T> create(String server, String module) {
        return doCreateCache(joinStr(server, module));
    }

    @Override
    public Cache<T> create(String server, String module, String func1, String... func2) {
        return doCreateCache(joinStr(server, joinStr(module, joinStr(func1, String.join("#", func2)))));
    }

    /**
     * 创建缓存
     *
     * @param prefix 前缀
     * @return 缓存
     */
    protected abstract Cache<T> doCreateCache(String prefix);

    /**
     * 目录连接
     *
     * @param key1 key
     * @param key2 value
     * @return joinStr
     */
    public static String joinStr(String key1, String key2) {
        return key1 + ":" + key2;
    }

}
