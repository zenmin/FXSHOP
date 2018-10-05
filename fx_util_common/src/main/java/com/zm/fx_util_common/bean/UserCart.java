package com.zm.fx_util_common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Describle This Class Is 购物车实体
 * @Author ZengMin
 * @Date 2018/10/5 12:38
 */
public class UserCart implements Serializable {

    private String userid;
    private List<Item> items;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
