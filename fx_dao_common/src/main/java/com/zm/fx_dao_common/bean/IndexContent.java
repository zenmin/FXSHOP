package com.zm.fx_dao_common.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
@TableName("tb_index_content")
public class IndexContent extends Model<IndexContent> {
    private Long id;

    private Long parentid;

    private String name;

    private String title;

    private String img;

    private String url;

    private String desc;

    private Date updated;

    private Date created;

    @Override
    public String toString() {
        return "IndexContent{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", img='" + img + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                '}';
    }

    public IndexContent(Long id, Long parentid, String name, String title, String img, String url, String desc, Date updated, Date created) {
        this.id = id;
        this.parentid = parentid;
        this.name = name;
        this.title = title;
        this.img = img;
        this.url = url;
        this.desc = desc;
        this.updated = updated;
        this.created = created;
    }

    public IndexContent() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
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