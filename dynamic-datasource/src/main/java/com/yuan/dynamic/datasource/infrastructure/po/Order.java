package com.yuan.dynamic.datasource.infrastructure.po;

import java.util.Date;

/**
 * @author hansiyuan
 * @date 2022年04月17日 15:24
 */
public class Order {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Integer orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getDistrictMoney() {
        return districtMoney;
    }

    public void setDistrictMoney(Integer districtMoney) {
        this.districtMoney = districtMoney;
    }

    public Integer getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(Integer paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public Date getOrderSettlementTime() {
        return orderSettlementTime;
    }

    public void setOrderSettlementTime(Date orderSettlementTime) {
        this.orderSettlementTime = orderSettlementTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRevision() {
        return revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
