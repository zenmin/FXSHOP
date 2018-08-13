package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_order")
public class Order extends Model<Order> {
    private Long id;

    private Long userid;

    private Integer status;

    private Date starttime;

    private Date endtime;

    private String activity;

    private Double allprice;

    private Double oldprice;

    private Double nowprice;

    private String payid;

    private Date updated;

    private Date created;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userid=" + userid +
                ", status=" + status +
                ", starttime=" + starttime +
                ", endtime=" + endtime +
                ", activity='" + activity + '\'' +
                ", allprice=" + allprice +
                ", oldprice=" + oldprice +
                ", nowprice=" + nowprice +
                ", payid='" + payid + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public Order(Long id, Long userid, Integer status, Date starttime, Date endtime, String activity, Double allprice, Double oldprice, Double nowprice, String payid, Date updated, Date created) {
        this.id = id;
        this.userid = userid;
        this.status = status;
        this.starttime = starttime;
        this.endtime = endtime;
        this.activity = activity;
        this.allprice = allprice;
        this.oldprice = oldprice;
        this.nowprice = nowprice;
        this.payid = payid;
        this.updated = updated;
        this.created = created;
    }

    public Order() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity == null ? null : activity.trim();
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }

    public Double getOldprice() {
        return oldprice;
    }

    public void setOldprice(Double oldprice) {
        this.oldprice = oldprice;
    }

    public Double getNowprice() {
        return nowprice;
    }

    public void setNowprice(Double nowprice) {
        this.nowprice = nowprice;
    }

    public String getPayid() {
        return payid;
    }

    public void setPayid(String payid) {
        this.payid = payid == null ? null : payid.trim();
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