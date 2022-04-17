package com.yuan.dynamic.datasource.infrastructure.mapper.bitch;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hansiyuan
 * @date 2022年04月17日 17:59
 */
public class OrderInsertTreadFactory implements ThreadFactory {
    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "order-insert-" + mThreadNum.getAndIncrement());
    }
}
