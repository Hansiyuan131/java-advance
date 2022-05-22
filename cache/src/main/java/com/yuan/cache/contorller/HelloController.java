package com.yuan.cache.contorller;

import com.alibaba.fastjson.JSON;
import com.yuan.cache.config.EnvConfig;
import com.yuan.cache.utils.RedisLock;
import com.yuan.cache.utils.RedisUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: Hello
 * @author: hansiyuan
 * @date: 2022/5/22 9:57 PM
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @Resource
    private EnvConfig envConfig;
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/hello")
    public String test() {
        RedisLock lock = new RedisLock(redisUtil, "test_key");
        try {
            long outTime = 1000L;
            if (lock.lock(outTime)) {
                Thread.sleep(500L);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return "ok";
    }
}
