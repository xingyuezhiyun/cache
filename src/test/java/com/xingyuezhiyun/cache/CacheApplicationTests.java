package com.xingyuezhiyun.cache;

import com.xingyuezhiyun.cache.cache.Cache;
import com.xingyuezhiyun.cache.redis.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class CacheApplicationTests {

    @Resource(type = RedisService.class)
    private RedisService<String> stringRedisService;

    @Resource(type = RedisService.class)
    private RedisService<Person> redisService;

    @Test
    void testRedis() {

        Cache<String> stringCache = stringRedisService.create("cache", "system");
        stringCache.setString("test0000", "abc000", 180);
        System.out.println(stringCache.getString("test0000"));

        Cache<Person> cache = redisService.create("cache", "system", "menu", "insert");
        Person person = new Person();
        person.setName("person0001-name");
        cache.set("person0001", person);
        Person person001 = cache.get("person0001");
        System.out.println(person001.getName());
    }

    public static class Person {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
