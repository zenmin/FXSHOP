package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class OrderItem  implements Serializable {
    private Long id;

    private Long orderid;

    private Long itemid;

    private String itemname;

    private String itemdesc;

    private Double allpruce;

    private Integer num;

    private Double oneprice;

    private String img;

    private String logisticscode;

    private Integer isreceive;

    private String updated;

    private String created;

    public OrderItem(Long id, Long orderid, Long itemid, String itemname, String itemdesc, Double allpruce, Integer num, Double oneprice, String img, String logisticscode, Integer isreceive, String updated, String created) {
        this.id = id;
        this.orderid = orderid;
        this.itemid = itemid;
        this.itemname = itemname;
        this.itemdesc = itemdesc;
        this.allpruce = allpruce;
        this.num = num;
        this.oneprice = oneprice;
        this.img = img;
        this.logisticscode = logisticscode;
        this.isreceive = isreceive;
        this.updated = updated;
        this.created = created;
    }

    public OrderItem() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc == null ? null : itemdesc.trim();
    }

    public Double getAllpruce() {
        return allpruce;
    }

    public void setAllpruce(Double allpruce) {
        this.allpruce = allpruce;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getOneprice() {
        return oneprice;
    }

    public void setOneprice(Double oneprice) {
        this.oneprice = oneprice;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getLogisticscode() {
        return logisticscode;
    }

    public void setLogisticscode(String logisticscode) {
        this.logisticscode = logisticscode == null ? null : logisticscode.trim();
    }

    public Integer getIsreceive() {
        return isreceive;
    }

    public void setIsreceive(Integer isreceive) {
        this.isreceive = isreceive;
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