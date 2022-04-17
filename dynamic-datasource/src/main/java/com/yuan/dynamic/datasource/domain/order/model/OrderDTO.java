package com.yuan.dynamic.datasource.domain.order.model;

import java.util.Date;

/**
 * @author hansiyuan
 * @date 2022年04月17日 15:42
 */
public class OrderDTO {
    /**
     * 订单ID
     */
    private Long id;
    /**
     * 订单编号
     */
    private Long orderNo;
    /**
     * 下单人ID
     */
    private Long userId;
    /**
     * 支付方式：0：未选择;1余额
     */
    private Integer paymentMethod;
    /**
     * 订单总金额
     */
    private Integer orderMoney;
    /**
     * 优惠总金额
     */
    private Integer districtMoney;
    /**
     * 支付总金额
     */
    private Integer paymentMoney;
    /**
     * '订单结算时间'
     */
    private Date orderSettlementTime;
    /**
     * 状态: -1已退款 0未结算 1已结算
     */
    private Integer state;
    /**
     * 乐观锁
     */
    private Integer revision;

    /**
     * 创建人
     */
    private Long createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * '更新人'
     */
    private Long updatedBy;
    /**
     * '更新时间'
     */
    private Date updatedTime;
}
