package com.yuan.dynamic.datasource.infrastructure.mapper;

import com.yuan.dynamic.datasource.infrastructure.mapper.primary.OrderMapper;
import com.yuan.dynamic.datasource.infrastructure.po.Order;
import com.yuan.dynamic.datasource.utils.SpringContextTool;
import lombok.extern.slf4j.Slf4j;

import java.applet.AppletContext;
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
    private CountDownLatch totalPageCount;
    private CountDownLatch batchPageCount;
    private Integer pageNum;

    public OrderBatchInsertTask(TaskParams taskParams) {
        this.taskParams = taskParams;
        this.batchPageCount = taskParams.getBatchPageCount();
        this.totalPageCount = taskParams.getTotalPageCount();
        this.pageNum = taskParams.getPageNum();
    }

    @Override
    public void run() {
        OrderMapper orderMapper = SpringContextTool.getBean(OrderMapper.class);
        // 查询页数
        System.out.println("操作第" + pageNum + "页数据");
        for (int i = 0; i < taskParams.getSize(); i++) {
            try {
                List<Order> orderList = builderOrderList();
                Long rows = orderMapper.batchInsert(orderList);
            } catch (Exception e) {
                log.error("batch insert error", e);
            }
        }
    }

    private List<Order> builderOrderList() {
        List<Order> order = new ArrayList<Order>();
        for (int i = 0; i < 28000; i++) {
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
