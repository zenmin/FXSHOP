package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_item_detail")
public class ItemDeatil extends Model<ItemDeatil> {
    private Long id;

    private Long itemid;

    private Date updated;

    private Date created;

    private String bigmsg;

    public ItemDeatil(Long id, Long itemid, Date updated, Date created, String bigmsg) {
        this.id = id;
        this.itemid = itemid;
        this.updated = updated;
        this.created = created;
        this.bigmsg = bigmsg;
    }

    @Override
    public String toString() {
        return "ItemDeatil{" +
                "id=" + id +
                ", itemid=" + itemid +
                ", updated=" + updated +
                ", created=" + created +
                ", bigmsg='" + bigmsg + '\'' +
                '}';
    }

    public ItemDeatil() {
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

    public Long getItemid() {
        return itemid;
    }

    public void setItemid(Long itemid) {
        this.itemid = itemid;
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

    public String getBigmsg() {
        return bigmsg;
    }

    public void setBigmsg(String bigmsg) {
        this.bigmsg = bigmsg == null ? null : bigmsg.trim();
    }
}