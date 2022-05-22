package com.yuan.cache.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.UUID;

/**
 * @description: redis分布式锁
 * @author: hansiyuan
 * @date: 2022/5/22 7:27 PM
 */
@Slf4j
public class RedisLock {

    private static final Long SUCCESS = 1L;

    /**
     * 毫秒和纳秒的换算
     */
    public static final long ONE_MILLI_NANOS = 1000000L;
    /**
     * 默认超时时间（毫秒）
     */
    public static final long DEFAULT_TIME_OUT = 3000;
    /**
     * 锁的超时时间（毫秒），过期删除
     */
    public static final int EXPIRE = 2 * 60 * 1000;

    private static SecureRandom secRandom = new SecureRandom();

    private RedisUtil redisUtil;

    private String key;

    private String uuid;

    public RedisLock(RedisUtil redisUtil, String key) {
        // 加lock前缀
        this.key = "lock:" + key;
        this.redisUtil = redisUtil;
        this.uuid = UUID.randomUUID().toString();
    }

    public boolean lock() {
        return lock(this.key, EXPIRE, DEFAULT_TIME_OUT);
    }

    /**
     * 功能描述：
     *
     * @param outTime 获取锁超时时间(毫秒)
     */
    public boolean lock(long outTime) {
        return lock(this.key, EXPIRE, outTime);
    }

    /**
     * @param expireTime 锁失效时间(毫秒)
     * @param outTime    获取锁超时时间(毫秒)
     */
    public boolean lock(long expireTime, long outTime) {
        return lock(this.key, expireTime, outTime);
    }

    /**
     * 功能描述：获取锁
     *
     * @param key        键值
     * @param expireTime 锁过期时间
     * @param outTime    获取锁超时时间
     */
    private boolean lock(String key, long expireTime, long outTime) {
        if (key == null || "".equals(key)) {
            return false;
        }

        this.key = key;
        long nano = System.nanoTime();
        outTime *= ONE_MILLI_NANOS;
        try {
            while ((System.nanoTime() - nano) < outTime) {
                if (redisUtil.setIfAbsent(key, uuid, expireTime)) {
                    return true;
                } else {
                    // 短暂休眠，避免出现活锁
                    Thread.sleep(200, secRandom.nextInt(500));
                }
            }
        } catch (Exception e) {
            log.error("获取锁异常，key=" + key, e);
        }
        return false;
    }

    /**
     * 解锁
     */
    public void unlock() {
        unlock(this.redisUtil, this.key, this.uuid);
    }

    /**
     * 解锁
     *
     * @param redisUtil redisUtil对象
     * @param key       key值
     * @param uuid      唯一值
     */
    private boolean unlock(RedisUtil redisUtil, String key, String uuid) {
        try {
            //用lua脚本解锁,保证原子性
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            RedisScript<Long> redisScript = new DefaultRedisScript<>(script, Long.class);
            Object result = redisUtil.execute(redisScript, Collections.singletonList(key), uuid);
            return SUCCESS.equals(result);
        } catch (Exception e) {
            log.error("释放锁异常，key=" + key, e);
        }
        return false;
    }
}
