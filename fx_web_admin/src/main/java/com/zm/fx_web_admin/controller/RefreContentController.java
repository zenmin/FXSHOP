package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.*;
import com.zm.fx_web_admin.service.RefreContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Describle This Class Is 门户管理
 * @Author ZengMin
 * @Date 2018/8/23 20:11
 */
@RestController
public class RefreContentController {

    @Autowired
    RefreContentService contentService;

    /**
     * 取所有分类
     * @return
     */
    @GetMapping("/content/getcates")
    public JSONObject getContentCates(){
        String contentCates = contentService.getContentCates();
        JSONArray objects = JSONArray.parseArray(contentCates);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("objects",objects);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    /**
     * 根据id取内容
     * @param id
     * @return
     */
    @GetMapping("/content/{id}")
    public JSONObject getContentById(@PathVariable Long id){
        String contentsById = contentService.getContentsById(id);
        JSONObject jsonObject = JSONObject.parseObject(contentsById);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    /**
     * 取所有内容
     * @param
     * @return
     */
    @GetMapping("/content/getall")
    public JSONObject getContentAll(){
        String contents = contentService.getContents();
        JSONObject jsonObject = JSONObject.parseObject(contents);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    /**
     * 更新内容
     * @param indexContent
     * @return
     */
    @PostMapping("/content/update")
    public JSONObject update(IndexContent indexContent){
        Boolean aBoolean = contentService.updateContent(indexContent);
        JSONObject jsonObject = new JSONObject();
        if(aBoolean){
            jsonObject.put("code","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("code","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

    /**
     * 新增内容
     * @param indexContent
     * @return
     */
    @PutMapping("/content/add")
    public JSONObject add(IndexContent indexContent){
        Boolean aBoolean = contentService.addContent(indexContent);
        JSONObject jsonObject = new JSONObject();
        if(aBoolean){
            jsonObject.put("code","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("code","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

    /**
     * 根据id删除
     * @param id
     * @return
     */
    @DeleteMapping("/content/{id}")
    public JSONObject delete(Long id){
        Boolean aBoolean = contentService.deleteById(id);
        JSONObject jsonObject = new JSONObject();
        if(aBoolean){
            jsonObject.put("code","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("code","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

}
