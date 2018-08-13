package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_content_category")
public class ContentCategory extends Model<ContentCategory> {
    private Long id;

    private String name;

    private Integer isparent;

    private Date updated;

    private Date created;

    public ContentCategory(Long id, String name, Integer isparent, Date updated, Date created) {
        this.id = id;
        this.name = name;
        this.isparent = isparent;
        this.updated = updated;
        this.created = created;
    }

    @Override
    public String toString() {
        return "ContentCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isparent=" + isparent +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public ContentCategory() {
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