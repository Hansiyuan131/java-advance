package com.yuan.dynamic.datasource.infrastructure.mapper.primary;

import com.yuan.dynamic.datasource.infrastructure.po.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年04月17日 15:45
 */
@Mapper
public interface OrderMapper {
    /**
     * 插入数据
     *
     * @param req 入参
     */
    long insert(Order req);

    /**
     * 批量插入
     *
     * @param orderList 请求列表
     * @return 响应
     */
    long batchInsert(List<Order> orderList);
}
