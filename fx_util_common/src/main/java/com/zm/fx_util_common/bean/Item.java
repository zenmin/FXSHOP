package com.zm.fx_util_common.bean;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
@Document(indexName = "items",type = "item")
public class Item  implements Serializable {
    private Long id;

    private Long categoryid;

    private String name;

    private String tiitle;

    private String describle;

    private String barcode;

    private Double price;

    private Integer num;

    private Integer status;

    private String updated;

    private String created;

    private ItemDeatil itemDeatil;

    private ItemCategory itemCategory;

    private String dmsg;

    private String imgurl;

    private Integer cartNum;    //购物车数量

    private Double cartPrice;    //购物车数量


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

    public Item(Long id, Long categoryid, String name, String tiitle, String describle, String barcode, Double price, Integer num, Integer status, String updated, String created, ItemDeatil itemDeatil, ItemCategory itemCategory, String dmsg, String imgurl) {
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
        this.itemDeatil = itemDeatil;
        this.itemCategory = itemCategory;
        this.dmsg = dmsg;
        this.imgurl = imgurl;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
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

    public Item() {
        super();
    }

    public Long getId() {
        return id;
    }

    public Integer getCartNum() {
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
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
        this.describle = describle == null ? null : describle.trim();
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
        this.updated = updated;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

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
                ", updated='" + updated + '\'' +
                ", created='" + created + '\'' +
                ", itemDeatil=" + itemDeatil +
                ", itemCategory=" + itemCategory +
                ", dmsg='" + dmsg + '\'' +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}