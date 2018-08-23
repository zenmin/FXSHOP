package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class ItemCategory  implements Serializable {
    private Long id;

    private Long parentid;

    private String name;

    private Integer status;

    private Long sortorder;

    private Integer isparent;

    private String updated;

    private String created;

    public ItemCategory(Long id, Long parentid, String name, Integer status, Long sortorder, Integer isparent, String updated, String created) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.status = status;
        this.sortorder = sortorder;
        this.isparent = isparent;
        this.updated = updated;
        this.created = created;
    }

    public ItemCategory() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getSortorder() {
        return sortorder;
    }

    public void setSortorder(Long sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
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