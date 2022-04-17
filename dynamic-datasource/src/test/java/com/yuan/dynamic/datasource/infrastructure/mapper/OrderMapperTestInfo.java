package com.yuan.dynamic.datasource.infrastructure.mapper;

import com.yuan.dynamic.datasource.infrastructure.mapper.primary.OrderMapper;
import com.yuan.dynamic.datasource.infrastructure.po.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author hansiyuan
 * @date 2022年04月17日 15:55
 */
@SpringBootTest
public class OrderMapperTestInfo {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void insert() {
        Order order = builderOrderInfo();
        System.out.println(orderMapper.insert(order));
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