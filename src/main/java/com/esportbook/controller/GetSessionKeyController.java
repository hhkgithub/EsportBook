package com.esportbook.controller;

import com.esportbook.utils.AESUtil;
import com.esportbook.utils.HttpUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;

/**
 * Created by hhkmac on 2017/4/19.
 */

@RestController
@Configuration
@ConfigurationProperties(prefix = "weixin")
public class GetSessionKeyController {
    private String weixinUrl;

    public String getWeixinUrl() {
        return weixinUrl;
    }

    public void setWeixinUrl(String weixinUrl) {
        this.weixinUrl = weixinUrl;
    }
    @RequestMapping(value = "/getSessionKey")
    public String getSessionKey(String code, String encrypdata, String iv){

        String url = "https://api.weixin.qq.com/sns/jscode2session?" +
                "appid=wx4dca5c416d4d7d82&secret=8a2e7c48db70ad240b8189a08482105b&" +
         "js_code="+ code +"&grant_type=authorization_code";
        System.out.println(url);
        System.out.println(encrypdata);
        System.out.println(iv);
        String str = HttpUtil.doGetSSL(url);//{"session_key":"BDqWlnMt+pbS7tKyYse\/ag==","expires_in":7200,"openid":"oV1cL0awsyo3ve8oUt2tI1tAz5Eo"}
        JSONObject jsonObject = null;
        String session_key=null;
        try {
            jsonObject = new JSONObject(str);
            session_key = (String) jsonObject.get("session_key");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        decodeUserInfo(encrypdata,iv,session_key);

        System.out.println(str);
        return str;
    }

    /**
     * 解密用户敏感数据
     * {"openId":"oV1cL0awsyo3ve8oUt2tI1tAz5Eo","nickName":"贺慧康","gender":1,"language":"zh_CN","city":"Zhengzhou","province":"Henan","country":"CN","avatarUrl":"http://wx.qlogo.cn/mmopen/vi_32/PiajxSqBRaELrrmQWHfySx2hvbwq1z1pyyhmN8ib9k3iapPS0ZIZ83YicMBV8qJrOBW9fjtBOQ3Po9ibt2icn2hnAEkA/0","watermark":{"timestamp":1492680433,"appid":"wx4dca5c416d4d7d82"}}
     */
    public void decodeUserInfo(String encryptedData,String iv,String session_key){
        try {
            byte[] resultByte = AESUtil.instance.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(session_key), Base64.decodeBase64(iv));
            if(null != resultByte && resultByte.length > 0){
                String userInfo = new String(resultByte, "UTF-8");
                System.out.println(userInfo);
            }
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
