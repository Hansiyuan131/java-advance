package com.yuan.small.spring.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hansiyuan
 * @date 2022年06月01日 23:15
 */
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小王");
        hashMap.put("10002", "小李");
        hashMap.put("10003", "小黑");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
