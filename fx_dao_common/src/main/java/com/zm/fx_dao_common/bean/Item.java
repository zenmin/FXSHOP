package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@TableName("tb_item")
public class Item extends Model<Item> {
    private String id;

    private Long categoryid;

    private String name;

    private String tiitle;

    private String describle;

    private String barcode;

    private Double price;

    private Integer num;

    private Integer status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updated;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String created;

    private String dmsg;

    private String imgurl;

    private ItemCategory itemCategory;

    private ItemDeatil itemDeatil;

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDmsg() {
        return dmsg;
    }

    public void setDmsg(String dmsg) {
        this.dmsg = dmsg;
    }

    public ItemDeatil getItemDeatil() {
        return itemDeatil;
    }

    public void setItemDeatil(ItemDeatil itemDeatil) {
        this.itemDeatil = itemDeatil;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }
    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", categoryid=" + categoryid +
                ", name='" + name + '\'' +
                ", tiitle='" + tiitle + '\'' +
                ", describle='" + describle + '\'' +
                ", barcode='" + barcode + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", status=" + status +
                ", updated='" + updated + '\'' +
                ", created='" + created + '\'' +
                ", dmsg='" + dmsg + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", itemCategory=" + itemCategory +
                ", itemDeatil=" + itemDeatil +
                '}';
    }

    public Item(String id, Long categoryid, String name, String tiitle, String describle, String barcode, Double price, Integer num, Integer status, String updated, String created, String dmsg, String imgurl, ItemCategory itemCategory, ItemDeatil itemDeatil) {
        this.id = id;
        this.categoryid = categoryid;
        this.name = name;
        this.tiitle = tiitle;
        this.describle = describle;
        this.barcode = barcode;
        this.price = price;
        this.num = num;
        this.status = status;
        this.updated = updated;
        this.created = created;
        this.dmsg = dmsg;
        this.imgurl = imgurl;
        this.itemCategory = itemCategory;
        this.itemDeatil = itemDeatil;
    }

    public Item() {
        super();
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
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

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated.substring(0,updated.length()-2);
    }

    public String getCreated() {
        return created;
    }
    public void setCreated(String created) {
        this.created = created.substring(0,created.length()-2);
    }
}