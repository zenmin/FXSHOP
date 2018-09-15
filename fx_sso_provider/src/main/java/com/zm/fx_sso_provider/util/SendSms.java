package com.zm.fx_sso_provider.util;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Describle This Class Is
 * //接口类型：互亿无线触发短信接口，支持发送验证码短信、订单通知短信等。
 * // 账户注册：请通过该地址开通账户
 * // 注意事项：
 * //（1）调试期间，请用默认的模板进行测试，默认模板详见接口文档；
 * //（2）请使用APIID（查看APIID请登录用户中心->验证码短信->产品总览->APIID）及 APIkey来调用接口；
 * //（3）该代码仅供接入互亿无线短信接口参考使用，客户可根据实际需要自行编写；
 * @Author ZengMin
 * @Date 2018/9/15 11:34
 */
@Component
public class SendSms {

    @Value("${MSGURL}")
    private String Url;
    @Value("${ACCOUNT}")
    private String account;
    @Value("${PASSWORD}")
    private String password;

    public int send(String tel) {

        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);

        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

        int mobile_code = (int)((Math.random()*9+1)*100000);

        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");

        NameValuePair[] data = {//提交短信
                new NameValuePair("account", account), //查看用户名是登录用户中心->验证码短信->产品总览->APIID
                new NameValuePair("password", password),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", tel),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);

            String SubmitResult =method.getResponseBodyAsString();

            //System.out.println(SubmitResult);

            Document doc = DocumentHelper.parseText(SubmitResult);
            Element root = doc.getRootElement();

            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");

            System.out.println(code);
            System.out.println(msg);
            System.out.println(smsid);

            if("2".equals(code)){
                System.out.println("短信提交成功");
                return mobile_code;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }
}
