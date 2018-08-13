package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_order_detail")
public class OrderDetail extends Model<OrderDetail> {
    private Long id;

    private Long orderid;

    private Long userid;

    private String username;

    private String userphone;

    private String useraddress;

    private Date updated;

    private Date created;

    public OrderDetail(Long id, Long orderid, Long userid, String username, String userphone, String useraddress, Date updated, Date created) {
        this.id = id;
        this.orderid = orderid;
        this.userid = userid;
        this.username = username;
        this.userphone = userphone;
        this.useraddress = useraddress;
        this.updated = updated;
        this.created = created;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderid=" + orderid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", userphone='" + userphone + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public OrderDetail() {
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