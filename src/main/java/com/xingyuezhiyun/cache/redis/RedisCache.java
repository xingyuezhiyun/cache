package com.xingyuezhiyun.cache.redis;

import com.xingyuezhiyun.cache.cache.Cache;
import com.xingyuezhiyun.cache.common.Serializer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisCache<T> implements Cache<T> {

    private final String prefix;
    private final Serializer serializer;
    private final RedisTemplate<String, T> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    public RedisCache(String prefix, Serializer serializer, RedisTemplate<String, T> redisTemplate, StringRedisTemplate stringRedisTemplate) {
        this.prefix = prefix;
        this.serializer = serializer;
        this.redisTemplate = redisTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(RedisService.joinStr(prefix, key));
    }

    @Override
    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(RedisService.joinStr(prefix, key), value);
    }

    @Override
    public void setString(String key, String value, int expire) {
        stringRedisTemplate.opsForValue().set(RedisService.joinStr(prefix, key), value, expire, TimeUnit.SECONDS);
    }

    @Override
    public T get(String key) {
        return redisTemplate.opsForValue().get(RedisService.joinStr(prefix, key));
    }

    @Override
    public void set(String key, T t) {
        redisTemplate.opsForValue().set(RedisService.joinStr(prefix, key), t);
    }

    @Override
    public void set(String key, T t, int expire) {
        redisTemplate.opsForValue().set(RedisService.joinStr(prefix, key), t, expire, TimeUnit.SECONDS);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public Long incr(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    @Override
    public Long incr(String key, Long value) {
        return redisTemplate.opsForValue().increment(key, value);
    }

    private T read(byte[] bytes, Class<T> clazz) {
        return serializer.read(bytes, clazz);
    }

    private byte[] write(T t) {
        return serializer.write(t);
    }
}
