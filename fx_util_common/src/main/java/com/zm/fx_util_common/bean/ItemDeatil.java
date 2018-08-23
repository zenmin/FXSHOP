package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class ItemDeatil  implements Serializable {
    private Long id;

    private String itemid;

    private String updated;

    private String created;

    private String bigmsg;

    public ItemDeatil(Long id, String itemid, String updated, String created, String bigmsg) {
        this.id = id;
        this.itemid = itemid;
        this.updated = updated;
        this.created = created;
        this.bigmsg = bigmsg;
    }

    public ItemDeatil() {
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
        this.itemid = itemid;
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

    public String getBigmsg() {
        return bigmsg;
    }

    public void setBigmsg(String bigmsg) {
        this.bigmsg = bigmsg == null ? null : bigmsg.trim();
    }
}