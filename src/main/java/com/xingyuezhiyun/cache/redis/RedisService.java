package com.xingyuezhiyun.cache.redis;

import com.xingyuezhiyun.cache.cache.AbstractCacheService;
import com.xingyuezhiyun.cache.cache.Cache;
import com.xingyuezhiyun.cache.common.Serializer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * redis缓存服务
 */
public class RedisService<T> extends AbstractCacheService<T> {

    private Serializer serializer;
    private RedisTemplate<String, T> redisTemplate;
    private StringRedisTemplate stringRedisTemplate;

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    public void setRedisTemplate(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    protected Cache<T> doCreateCache(String prefix) {
        return new RedisCache<>(prefix, serializer, redisTemplate, stringRedisTemplate);
    }

}
