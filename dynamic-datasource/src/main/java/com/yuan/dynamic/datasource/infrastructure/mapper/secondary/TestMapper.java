package com.yuan.dynamic.datasource.infrastructure.mapper.secondary;

import com.yuan.dynamic.datasource.infrastructure.po.Order;
import com.yuan.dynamic.datasource.infrastructure.po.TestInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hansiyuan
 * @date 2022年04月17日 15:45
 */
@Mapper
public interface TestMapper {
    /**
     * 插入数据
     *
     * @param req 入参
     */
    long insert(TestInfo req);
}
