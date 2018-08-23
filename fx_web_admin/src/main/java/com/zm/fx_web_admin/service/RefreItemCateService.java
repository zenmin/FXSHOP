package com.zm.fx_web_admin.service;

import com.zm.fx_util_common.bean.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle This Class Is 商品分类接口调用Service
 * @Author ZengMin
 * @Date 2018/8/12 11:36
 */
@Service
public class RefreItemCateService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 查父节点
     * @return
     */
    public String findParent() {
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/itemcate/findparent", String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }

    /**
     * 查全部
     * @return
     */
    public String findAll() {
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/itemcate/findall", String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }

    /**
     * 根据id 查分类
     * @param id
     * @return
     */
    public String findById(Integer id) {
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/itemcate/findbyid/"+id, String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }

    /**
     * 根据父节点id 查分类
     * @param id
     * @return
     */
    public String findByPid(Long id) {
        String forObject = restTemplate.getForObject("http://FXITEMPROVIDER/itemcate/findbypid/"+id, String.class);//直接写提供者名称/rest接口调用远程服务
        return forObject;
    }
}
