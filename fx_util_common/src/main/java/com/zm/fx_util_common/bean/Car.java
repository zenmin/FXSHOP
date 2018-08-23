package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class Car  implements Serializable {
    private Long id;

    private String itemid;

    private Integer num;

    private Double allprice;

    private String addtime;

    private String updated;

    private String created;

    public Car(Long id, String itemid, Integer num, Double allprice, String addtime, String updated, String created) {
        this.id = id;
        this.itemid = itemid;
        this.num = num;
        this.allprice = allprice;
        this.addtime = addtime;
        this.updated = updated;
        this.created = created;
    }

    public Car() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid == null ? null : itemid.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getAllprice() {
        return allprice;
    }

    public void setAllprice(Double allprice) {
        this.allprice = allprice;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
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
}