package com.zm.fx_dao_common.bean;

import java.util.Date;

public class ItemTalk {
    private Long id;

    private Long itemid;

    private Long userid;

    private String img;

    private String describle;

    private Date updated;

    private Date created;

    public ItemTalk(Long id, Long itemid, Long userid, String img, String describle, Date updated, Date created) {
        this.id = id;
        this.itemid = itemid;
        this.userid = userid;
        this.img = img;
        this.describle = describle;
        this.updated = updated;
        this.created = created;
    }

    public ItemTalk() {
        super();
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle == null ? null : describle.trim();
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