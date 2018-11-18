package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class OrderDetail  implements Serializable {
    private Long id;

    private Long orderid;

    private Long userid;

    private String username;

    private String userphone;

    private String useraddress;

    private String updated;

    private String created;

    private String addressid;

    private String itemid;

    private String type;

    public OrderDetail(Long id, Long orderid, Long userid, String username, String userphone, String useraddress, String updated, String created) {
        this.id = id;
        this.orderid = orderid;
        this.userid = userid;
        this.username = username;
        this.userphone = userphone;
        this.useraddress = useraddress;
        this.updated = updated;
        this.created = created;
    }

    public OrderDetail() {
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress == null ? null : useraddress.trim();
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

    public String getAddressid() {
        return addressid;
    }

    public void setAddressid(String addressid) {
        this.addressid = addressid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}