package com.yuan.dynamic.datasource.infrastructure.mapper.bitch;

import com.yuan.dynamic.datasource.infrastructure.mapper.primary.OrderMapper;
import com.yuan.dynamic.datasource.infrastructure.po.Order;
import com.yuan.dynamic.datasource.utils.SpringContextTool;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @description: 订单批量插入任务
 * @author: hansiyuan
 * @date: 2022/4/17 5:43 PM
 */
@Slf4j
public class OrderBatchInsertTask implements Runnable {

    private TaskParams taskParams;
    private CountDownLatch totalBatchCount;
    private CountDownLatch loopBatchCount;

    public OrderBatchInsertTask(TaskParams taskParams) {
        this.taskParams = taskParams;
        this.loopBatchCount = taskParams.getLoopBatchCount();
        this.totalBatchCount = taskParams.getTotalBatchCount();
    }

    @Override
    public void run() {
        OrderMapper orderMapper = SpringContextTool.getBean(OrderMapper.class);
        List<Order> orderList = builderOrderList();
        Long rows = orderMapper.batchInsert(orderList);
        log.info("成功插入 {} 行数据", rows);
        loopBatchCount.countDown();
        totalBatchCount.countDown();
    }

    private List<Order> builderOrderList() {
        List<Order> order = new ArrayList<Order>();
        for (int i = 0; i < taskParams.getSize(); i++) {
            order.add(builderOrderInfo());
        }
        return order;
    }

    private Order builderOrderInfo() {
        Order order = new Order();
        order.setUserId(10001L);
        order.setDistrictMoney(0);
        order.setOrderMoney(100);
        order.setPaymentMoney(100);
        order.setOrderSettlementTime(new Date());
        order.setOrderNo(System.currentTimeMillis());
        order.setState(1);
        order.setPaymentMethod(1);
        return order;
    }
}
