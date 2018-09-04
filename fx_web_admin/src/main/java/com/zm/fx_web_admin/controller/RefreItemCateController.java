package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zm.fx_web_admin.service.RefreItemCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Describle This Class Is 分类服务
 * @Author ZengMin
 * @Date 2018/8/12 11:33
 */
@RestController
@RequestMapping("/itemcate")
public class RefreItemCateController {

    @Autowired
    RefreItemCateService refreItemCateService;

    /**
     * 查全部分类
     * @return
     */
    @GetMapping("/findall")
    public JSONObject findAll(){
        String all = refreItemCateService.findAll();
        JSONArray objects = JSONArray.parseArray(all);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("objects",objects);

        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/findbyid/{id}")
    public JSONObject findById(@PathVariable Integer id){
        String all = refreItemCateService.findById(id);
        JSONObject jsonObject = JSONObject.parseObject(all);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }


    /**
     * 取所有父节点
     * @return
     */
    @GetMapping("/findparent")
    public JSONObject findParent(){
        String all = refreItemCateService.findParent();
        JSONArray objects = JSONArray.parseArray(all);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("objects",objects);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    /**
     * 根据父节点id查询
     * @return
     */
    @GetMapping("/findbypid/{id}")
    public JSONObject findParentById(@PathVariable String id){
        String all = refreItemCateService.findByPid(id);
        JSONArray objects = JSONArray.parseArray(all);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("objects",objects);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

}
