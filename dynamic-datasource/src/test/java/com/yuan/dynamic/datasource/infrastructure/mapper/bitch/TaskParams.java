package com.yuan.dynamic.datasource.infrastructure.mapper.bitch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 订单批量插入参数
 * @author: hansiyuan
 * @date: 2022/4/17 5:45 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskParams implements Serializable {
    private static final long serialVersionUID = -2595701094521955595L;

    /**
     * 单次插入条数
     */
    private Integer size;

    /**
     * 错误批次
     */
    private AtomicLong errorNum;

    /**
     * 成功批次
     */
    private AtomicLong successfulNum;

    /**
     * 发送总页数计数
     */
    private CountDownLatch totalBatchCount;

    /**
     * 发送批次计数
     */
    private CountDownLatch loopBatchCount;
}
