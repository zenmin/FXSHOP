package com.zm.fx_web_admin.service;

import com.zm.fx_util_common.bean.IndexContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Describle This Class Is 内容service
 * @Author ZengMin
 * @Date 2018/8/23 20:11
 */
@Service
public class RefreContentService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 查所有内容分类
     * @return
     */
    public String getContentCates(){
        String forObject = restTemplate.getForObject("http://FXCMSPROVIDER/content/getcates", String.class);
        return forObject;
    }

    /**
     * 取所有首页内容
     * @return
     */
    public String getContents(){
        String forObject = restTemplate.getForObject("http://FXCMSPROVIDER/content/getall", String.class);
        return forObject;
    }


    /**
     * 根据id取所有首页内容
     * @return
     */
    public String getContentsById(Long id){
        String forObject = restTemplate.getForObject("http://FXCMSPROVIDER/content/{1}", String.class,id);
        return forObject;
    }

    /**
     * 根据pid取所有首页内容
     * @return
     */
    public String getContentByPid(Long parentid){
        String forObject = restTemplate.getForObject("http://FXCMSPROVIDER/content/parent/{1}", String.class,parentid);
        return forObject;
    }

    public Boolean addContent(IndexContent indexContent) {
        try {
            restTemplate.put("http://FXCMSPROVIDER/content/add",indexContent);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateContent(IndexContent indexContent) {
        try {
            restTemplate.postForEntity("http://FXCMSPROVIDER/content/update",indexContent,String.class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteById(String id) {
        try {
            restTemplate.delete("http://FXCMSPROVIDER/content/delete/"+id,String.class);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
