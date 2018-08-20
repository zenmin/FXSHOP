package com.zm.fx_util_common.util;

import java.io.Serializable;

/**
 * @Describle This Class Is 通用返回实体
 * @Author ZengMin
 * @Date 2018/8/13 19:26
 */
public class ResponseEntity implements Serializable {
    private String code = "200";
    private String msg = "成功";
    private Object object;
    private Object page;

    public Object getPage() {
        return page;
    }
    public void setPage(Object page) {
        this.page = page;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                ", page=" + page +
                '}';
    }
}
