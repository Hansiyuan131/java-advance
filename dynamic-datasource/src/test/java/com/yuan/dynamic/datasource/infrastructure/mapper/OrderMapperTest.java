package com.yuan.dynamic.datasource.infrastructure.mapper;

import com.alibaba.fastjson.JSON;
import com.yuan.dynamic.datasource.infrastructure.mapper.primary.OrderMapper;
import com.yuan.dynamic.datasource.infrastructure.po.Order;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.rules.Stopwatch;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年04月17日 15:55
 */
@SpringBootTest
@Slf4j
public class OrderMapperTest {

    private static final int CORE = Math.min(Runtime.getRuntime().availableProcessors() * 2, 16);

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void insert() {
        Order order = builderOrderInfo();
        System.out.println(orderMapper.insert(order));
    }

    @Test
    public void bitchInsert() {
        StopWatch stopWatch = new StopWatch("batchInsert");
        stopWatch.start();
        List<Order> orderList = builderOrderList();
        Long rows = orderMapper.batchInsert(orderList);
        log.info("插入条数：{}", rows);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
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