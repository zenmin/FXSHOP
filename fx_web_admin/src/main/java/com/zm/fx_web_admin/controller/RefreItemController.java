package com.zm.fx_web_admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.zm.fx_util_common.bean.Item;
import com.zm.fx_util_common.util.OssUpload;
import com.zm.fx_web_admin.service.RefreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;

/**
 * @Describle This Class Is 商品访问层
 * @Author ZengMin
 * @Date 2018/8/12 11:33
 */
@RestController
@RequestMapping("/item")
public class RefreItemController {

    @Autowired
    RefreItemService refreItemService;
    @Autowired
    OssUpload ossUpload;
    @Value("${IMGURL}")
    private String imgurl;

    @GetMapping("/findall")
    public JSONObject findAll(int start, int size, @RequestParam(value = "sort",required = false) String sort){
        String all = refreItemService.findAll(start,size,sort);
        JSONObject jsonObject = JSONObject.parseObject(all);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    @GetMapping("/findbyid/{id}")
    public JSONObject findAll(@PathVariable String id){
        String all = refreItemService.findById(id);
        JSONObject jsonObject = JSONObject.parseObject(all);
        jsonObject.put("code","200");
        jsonObject.put("msg","成功");
        return jsonObject;
    }

    /**
     * 更新商品
     * @param item
     * @return
     */
    @PostMapping("/update")
    public JSONObject findAll(Item item){
        JSONObject jsonObject = new JSONObject();
        Boolean aBoolean = refreItemService.updateItem(item);
        if(aBoolean){
            jsonObject.put("status","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("status","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public JSONObject delete(@PathVariable String id){
        JSONObject jsonObject = new JSONObject();
        Boolean delete = refreItemService.delete(id);
        if(delete){
            jsonObject.put("status","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("status","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

    /**
     * 新增商品
     * @param item
     * @return
     */
    @PutMapping("/add")
    public JSONObject add(Item item){
        JSONObject jsonObject = new JSONObject();
        Boolean delete = refreItemService.add(item);
        if(delete){
            jsonObject.put("status","200");
            jsonObject.put("msg","成功");
        }else{
            jsonObject.put("status","500");
            jsonObject.put("msg","失败");
        }
        return jsonObject;
    }

    /**
     * 图片上传
     * @param file
     * @return
     */
    @PostMapping("/uploadimg")
    public JSONObject upload(HttpServletRequest request, MultipartFile file) {
        JSONObject result = new JSONObject();
        try{
            //传输文件至阿里oss
            InputStream inputStream = file.getInputStream();
            String contentType = file.getContentType();
            String[] split = contentType.split("/");
            String hz = split[split.length-1];
            String imgName = request.getSession().getId().substring(0,5) + System.currentTimeMillis() + "." + hz;
            String imgUrl = ossUpload.fileUploadByInputStream(inputStream, imgName);
            System.out.println("访问地址："+ imgUrl);
            if(!StringUtils.isEmpty(imgUrl)){
                JSONObject img = new JSONObject();
                result.put("code","0");
                result.put("msg","上传成功");
                img.put("src",imgUrl);
                result.put("data",img);
                return result;
            }
        }catch(Exception e){
            e.printStackTrace();
            result.put("code","500");
            result.put("msg","上传失败，请检查网络连接！");
            return result;
        }
        return result;
    }

}
