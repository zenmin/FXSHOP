package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONArray;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zm.fx_util_common.bean.IndexContent;
import com.zm.fx_web_admin.service.RefreContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Describle This Class Is 视图控制层
 * @Author ZengMin
 * @Date 2018/8/9 20:30
 */
@Controller
public class ViewController {

    @Autowired
    RefreContentService contentService;

    @GetMapping("/admin/{page}")
    public String toPage(@PathVariable String page) {
        return "admin/" +page;
    }

    @GetMapping("/fxshop/{page}")
    public String toIndexPage(@PathVariable String page) {
        return "fxshop/" +page;
    }

    @GetMapping("/")
    @Hystrix
    public String toIndex(Model model) {
        String contentByPid = contentService.getContentByPid(2L);
        List<IndexContent> indexContents = JSONArray.parseArray(contentByPid, IndexContent.class);
        model.addAttribute("lbimg",indexContents);
        //右侧轮播
        String ylbs = contentService.getContentByPid(13L);
        List<IndexContent> indexContentList = JSONArray.parseArray(ylbs, IndexContent.class);
        model.addAttribute("ylbs",indexContentList);
        return "fxshop/index";
    }

}
