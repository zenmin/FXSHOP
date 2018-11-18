package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class OrderPay  implements Serializable {
    private Long id;

    private Long userid;

    private String payid;

    private Long orderid;

    private Double allprice;

    private Integer status;

    private String updated;

    private String created;

    private String payway;

    public OrderPay(Long id, Long userid, String payid, Long orderid, Double allprice, Integer status, String updated, String created, String payway) {
        this.id = id;
        this.userid = userid;
        this.payid = payid;
        this.orderid = orderid;
        this.allprice = allprice;
        this.status = status;
        this.updated = updated;
        this.created = created;
        this.payway = payway;
    }

    public OrderPay() {
        super();
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

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPayway() {
        return payway;
    }

    public void setPayway(String payway) {
        this.payway = payway;
    }
}