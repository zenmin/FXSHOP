package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@TableName("tb_item_category")
public class ItemCategory extends Model<ItemCategory> {
    private Long id;

    private Long parentid;

    private String name;

    private Integer status;

    private Long sortorder;

    private Integer isparent;

    private Date updated;

    private Date created;

    public ItemCategory(Long id, Long parentid, String name, Integer status, Long sortorder, Integer isparent, Date updated, Date created) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.status = status;
        this.sortorder = sortorder;
        this.isparent = isparent;
        this.updated = updated;
        this.created = created;
    }

    @Override
    public String toString() {
        return "ItemCategory{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sortorder=" + sortorder +
                ", isparent=" + isparent +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public ItemCategory() {
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