package com.zm.fx_util_common;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.BucketInfo;
import com.aliyun.oss.model.PutObjectResult;
import com.zm.fx_util_common.util.OssUpload;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FxUtilCommonApplicationTests {
    // endpoint 访问OSS的域名
    private static String endPoint = "https://oss-cn-shenzhen.aliyuncs.com";

    // accessKeyId和accessKeySecret OSS的访问密钥
    private static String accessKeyId = "LTAIIaTZjOEQTf2D";
    private static String accessKeySecret = "ovsJDewsiEyNeObiBbdPzclWSOibCg";

    // Bucket 用来管理所存储Object的存储空间
    private static String bucketName = "fxshopbucket";

    // Object OSS存储数据的基本单元，称为OSS的对象或OSS的文件
    private static String testKey = "SendCard.js";

    @Autowired
    OssUpload ossUpload;
    @Test
    public void contextLoads() {
            // 生成OSSClient
            OSSClient ossClient = new OSSClient(endPoint, accessKeyId, accessKeySecret);

            try {
                // 判断Bucket是否存在
                if (ossClient.doesBucketExist(bucketName)) {
                    System.out.println("您已经创建Bucket：" + bucketName + "。");
                } else {
                    System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
                    // 创建Bucket
                    ossClient.createBucket(bucketName);
                }

                // 查看Bucket信息
                BucketInfo info = ossClient.getBucketInfo(bucketName);
                System.out.println("Bucket " + bucketName + "的信息如下：");
                System.out.println("\t数据中心：" + info.getBucket().getLocation());
                System.out.println("\t创建时间：" + info.getBucket().getCreationDate());
                System.out.println("\t用户标志：" + info.getBucket().getOwner());


                // 上传文件到OSS，Object的名称为fileKey
                String fileKey = "AB1C09B36923A347C46E8A08C959F930.png";
                //运行时注意修改File路径及文件名
                PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileKey, new File("C:\\Users\\74170\\Pictures\\FLAMING MOUNTAIN.png"));
                System.out.println(putObjectResult.getETag());

             /*
                // 把字符串存入OSS，Object的名称为testKey
                InputStream is = new ByteArrayInputStream("Test OSS putObject".getBytes());
                ossClient.putObject(bucketName, testKey, is);
                System.out.println("Object：" + testKey + "存入OSS成功。");

                // 下载Object
                OSSObject ossObject = ossClient.getObject(bucketName, testKey);
                InputStream inputStream = ossObject.getObjectContent();
                StringBuilder objectContent = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    String line = reader.readLine();
                    if (line == null)
                        break;
                    objectContent.append(line);
                }
                inputStream.close();
                System.out.println("Object：" + testKey + "的内容是：" + objectContent);



                // 查看Bucket中的Object
                ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(bucketName).
                        withMaxKeys(300));
                List<OSSObjectSummary> objectSummary = objectListing.getObjectSummaries();
                System.out.println("您有以下Object：");
                for (OSSObjectSummary object : objectSummary) {
                    System.out.println("\t" + object.getKey());
                }

                // 下载object到本地文件
                ossClient.getObject(new GetObjectRequest(bucketName, "全球经济与市场展望.pdf"), new File("F:/mvn/test.pdf"));

                // 删除Object
                ossClient.deleteObject(bucketName, testKey);
                System.out.println("删除Object：" + testKey + "成功。");
                ossClient.deleteObject(bucketName, fileKey);
                System.out.println("删除Object：" + fileKey + "成功。");

            } catch (OSSException oe) {
                oe.printStackTrace();
            } catch (ClientException ce) {
                ce.printStackTrace();
            */
            }
            catch (Exception e) {
                e.printStackTrace();
            } finally {
                ossClient.shutdown();
            }

    }

    @Test
    public void test1(){
        String filePath = "C:/Users/74170/AppData/Local/Temp/tomcat-docbase.1804105614647631101.8000/temp/F4A698DB5404D2C6FB0B08ED5E190034.png";
        String s = ossUpload.fileUpload(filePath);
        System.out.println(s);
    }

}

