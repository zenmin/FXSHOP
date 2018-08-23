package com.zm.fx_util_common.util;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.InputStream;

/**
 * @Describle This Class Is OssUpload
 * @Author ZengMin
 * @Date 2018/8/21 19:24
 */
@Component
@PropertySource({"application.properties"})
public class OssUpload {
    // endpoint 访问OSS的域名
    @Value("${ENDPOINT}")
    private String endPoint;
    // accessKeyId和accessKeySecret OSS的访问密钥
    @Value("${ACCESSKEYID}")
    private  String accessKeyId;
    @Value("${ACCESSKEYSECRET}")
    private  String accessKeySecret;
    // Bucket 用来管理所存储Object的存储空间
    @Value("${BUCKETNAME}")
    private  String bucketName;
    @Value("${IMGURL}")
    private String imgurl;

    //根据路径上传
    public String fileUpload(String filePath){
        // 生成OSSClient
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        // 上传文件到OSS，Object的名称为fileKey
        String split[] = filePath.split("/");
        String fileName = split[split.length-1];
        //运行时注意修改File路径及文件名
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, new File(filePath));
        String eTag = putObjectResult.getETag();
        if(!StringUtils.isEmpty(eTag)){
            return imgurl+fileName;
        }else{
            return null;
        }
    }

    //根据流上传
    public String fileUploadByInputStream(InputStream inputStream,String fileName){
        // 生成OSSClient
        OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);
        // 上传文件到OSS，Object的名称为fileKey
        //运行时注意修改File路径及文件名
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, inputStream);
        String eTag = putObjectResult.getETag();
        if(!StringUtils.isEmpty(eTag)){
            return imgurl+fileName;
        }else{
            return null;
        }
    }
}
