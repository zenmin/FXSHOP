package com.zm.fx_util_common.bean;

import java.io.Serializable;

public class ContentCategory  implements Serializable {
    private Long id;

    private String name;

    private Integer isparent;

    private String updated;

    private String created;

    public ContentCategory(Long id, String name, Integer isparent, String updated, String created) {
        this.id = id;
        this.name = name;
        this.isparent = isparent;
        this.updated = updated;
        this.created = created;
    }

    public ContentCategory() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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