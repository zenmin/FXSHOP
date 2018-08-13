package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_item")
public class Item extends Model<Item> {
    private Long id;

    private Long categoryid;

    private String name;

    private String tiitle;

    private String describle;

    private String barcode;

    private Double price;

    private Integer num;

    private Integer status;

    private Date updated;

    private Date created;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", categoryid=" + categoryid +
                ", name='" + name + '\'' +
                ", tiitle='" + tiitle + '\'' +
                ", describle='" + describle + '\'' +
                ", barcode='" + barcode + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", status=" + status +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public Item(Long id, Long categoryid, String name, String tiitle, String desc, String barcode, Double price, Integer num, Integer status, Date updated, Date created) {
        this.id = id;
        this.categoryid = categoryid;
        this.name = name;
        this.tiitle = tiitle;
        this.describle = desc;
        this.barcode = barcode;
        this.price = price;
        this.num = num;
        this.status = status;
        this.updated = updated;
        this.created = created;
    }

    public Item() {
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

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTiitle() {
        return tiitle;
    }

    public void setTiitle(String tiitle) {
        this.tiitle = tiitle == null ? null : tiitle.trim();
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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