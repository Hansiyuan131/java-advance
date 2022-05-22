package com.yuan.cache.config;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.Duration;

/**
 * @description: redis 配置
 * @author: hansiyuan
 * @date: 2022/5/22 10:00 PM
 */
@Configuration
public class RedisConfig {
    @Resource
    private EnvConfig envConfig;

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //使用Fastjson2JsonRedisSerializer序列化value的值
        redisTemplate.setValueSerializer(new FastJson2JsonRedisSerializer<>(Serializable.class));
        redisTemplate.setConnectionFactory(connectionFactory);

        return redisTemplate;
    }

    @Bean(name = "stockRedisTemplate")
    public RedisTemplate<String, Object> stockRedisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }

    /**
     * 配置 RedisCacheManager，使用 cache 注解管理 redis 缓存
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 初始化一个RedisCacheWriter
        RedisCacheWriter cacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);

        // 设置默认过期时间：30 分钟
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
                .computePrefixWith(cacheKeyPrefix -> envConfig.getEnv() + ":" + cacheKeyPrefix)
                .entryTtl(Duration.ofSeconds(120))
                // .disableCachingNullValues()
                // 使用注解时的序列化、反序列化
                .serializeKeysWith(MyRedisCacheManager.STRING_PAIR)
                .serializeValuesWith(MyRedisCacheManager.FASTJSON_PAIR);

        return new MyRedisCacheManager(cacheWriter, defaultCacheConfig);
    }
}
