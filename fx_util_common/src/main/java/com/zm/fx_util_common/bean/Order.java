package com.zm.fx_util_common.bean;


import java.io.Serializable;

public class Order  implements Serializable {
    private Long id;

    private Long userid;

    private Integer status;

    private String starttime;

    private String endtime;

    private String activity;

    private Double allprice;

    private Double oldprice;

    private Double nowprice;

    private String payid;

    private String updated;

    private String created;

    private String payway;

    public Order(Long id, Long userid, Integer status, String starttime, String endtime, String activity, Double allprice, Double oldprice, Double nowprice, String payid, String updated, String created, String payway) {
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
        this.payway = payway;
    }

    public Order() {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
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