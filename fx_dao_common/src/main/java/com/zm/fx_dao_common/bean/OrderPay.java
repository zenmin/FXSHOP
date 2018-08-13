package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_order_pay")
public class OrderPay extends Model<OrderPay> {
    private Long id;

    private Long userid;

    private String payid;

    private Long orderid;

    private Double allprice;

    private Integer status;

    private Date updated;

    private Date created;

    public OrderPay(Long id, Long userid, String payid, Long orderid, Double allprice, Integer status, Date updated, Date created) {
        this.id = id;
        this.userid = userid;
        this.payid = payid;
        this.orderid = orderid;
        this.allprice = allprice;
        this.status = status;
        this.updated = updated;
        this.created = created;
    }

    @Override
    public String toString() {
        return "OrderPay{" +
                "id=" + id +
                ", userid=" + userid +
                ", payid='" + payid + '\'' +
                ", orderid=" + orderid +
                ", allprice=" + allprice +
                ", status=" + status +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public OrderPay() {
        super();
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}