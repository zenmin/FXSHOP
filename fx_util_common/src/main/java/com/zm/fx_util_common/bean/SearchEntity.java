package com.zm.fx_util_common.bean;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * @Describle This Class Is
 * @Author ZengMin
 * @Date 2018/9/5 19:38
 */
public class SearchEntity {

    private Object object;
    private int page;
    private int size;
    private Sort sort;
    private long num;
    public static SearchEntity convertObj(Page page){
        SearchEntity searchEntity = new SearchEntity();
        searchEntity.setObject(page.getContent());
        searchEntity.setPage(page.getNumber());
        searchEntity.setSize(page.getSize());
        searchEntity.setSort(page.getSort());
        long totalElements = page.getTotalElements();
        searchEntity.setNum(totalElements);
        return searchEntity;
    }
    public Object getObject() {
        return object;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
