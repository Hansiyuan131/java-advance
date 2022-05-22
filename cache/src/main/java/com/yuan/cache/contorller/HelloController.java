package com.yuan.cache.contorller;

import com.yuan.cache.config.EnvConfig;
import com.yuan.cache.utils.RedisLock;
import com.yuan.cache.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: Hello
 * @author: hansiyuan
 * @date: 2022/5/22 9:57 PM
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class HelloController {

    @Resource
    private EnvConfig envConfig;
    @Resource
    private RedisUtil redisUtil;

    @Resource(name = "stockRedisTemplate")
    private RedisTemplate<String, Object> stockRedisTemplate;

    @RequestMapping("/hello")
    public String test() {
        String key = "test_key:";
        RedisLock lock = new RedisLock(redisUtil, key);
        try {
            long outTime = 1000L;
            if (lock.lock(outTime)) {
                if (Integer.parseInt(String.valueOf(stockRedisTemplate.opsForValue().get("IPHONE_STOCK:"))) <= 0) {
                    return "无库存";
                }
                long stock = stockRedisTemplate.opsForValue().decrement("IPHONE_STOCK:");
                System.out.println("IPhone " + stock + " 正在被抢....");
            }
        } finally {
            lock.unlock();
        }
        return "ok";
    }

    @RequestMapping("/stock/{stockCount}")
    public String setStock(@PathVariable String stockCount) {
        stockRedisTemplate.opsForValue().set("IPHONE_STOCK:", stockCount);
        return (String) stockRedisTemplate.opsForValue().get("IPHONE_STOCK:");
    }

    @RequestMapping("/stock/inc")
    public Long inc() {
        return stockRedisTemplate.opsForValue().increment("IPHONE_STOCK:");
    }

    @RequestMapping("/stock/dec")
    public Long dec() {
        return stockRedisTemplate.opsForValue().decrement("IPHONE_STOCK:");
    }
}
