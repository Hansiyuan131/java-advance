package com.yuan.dynamic.datasource.infrastructure.repository;

import com.yuan.dynamic.datasource.domain.order.repository.OrderRepository;
import com.yuan.dynamic.datasource.infrastructure.mapper.primary.OrderMapper;

import javax.annotation.Resource;

/**
 * 订单仓储实现类
 *
 * @author hansiyuan
 * @date 2022年04月17日 15:43
 */
public class OrderRepositoryImpl implements OrderRepository {

    @Resource
    private OrderMapper orderMapper;


}
