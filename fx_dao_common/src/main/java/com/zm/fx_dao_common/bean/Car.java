package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_car")
public class Car extends Model<Car> {
    private Long id;

    private String itemid;

    private Integer num;

    private Double allprice;

    private Date addtime;

    private Date updated;

    private Date created;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", itemid='" + itemid + '\'' +
                ", num=" + num +
                ", allprice=" + allprice +
                ", addtime=" + addtime +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public Car(Long id, String itemid, Integer num, Double allprice, Date addtime, Date updated, Date created) {
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

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
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