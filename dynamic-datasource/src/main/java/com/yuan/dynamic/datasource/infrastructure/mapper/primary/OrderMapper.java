package com.yuan.dynamic.datasource.infrastructure.mapper.primary;

import com.yuan.dynamic.datasource.infrastructure.po.Order;
import org.apache.ibatis.annotations.Mapper;

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
}
