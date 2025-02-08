package com.saki.javaUtil.feishu.utils;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.saki.javaUtil.feishu.dto.FeishuPushMessageRequest;
import com.saki.javaUtil.feishu.dto.FeishuPushMessageResponse;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FeishuRobotSender {
    public static FeishuPushMessageResponse sendMessage(String webhook, FeishuPushMessageRequest request,String secret) {
        String url = webhook;
        String timestamp = "" + System.currentTimeMillis() / 1000;//验签
        String sign = "";
        if (secret != null)
            try {
                sign = genSign(secret, timestamp);
            } catch (NoSuchAlgorithmException | InvalidKeyException e) {
                e.printStackTrace();
            }
        request.setTimestamp(Long.parseLong(timestamp));
        request.setSign(sign);
        String json = JSONUtil.toJsonStr(request);
        System.out.println("json:" + json);
        String response = HttpUtil.post(url, json);
        FeishuPushMessageResponse feishuPushMessageResponse = JSONUtil.toBean(response, FeishuPushMessageResponse.class);
        System.out.println("response:" + response);
        return feishuPushMessageResponse;
    }

    private static String genSign(String secret, String timestamp) throws NoSuchAlgorithmException, InvalidKeyException {
        //把timestamp+"\n"+密钥当做签名字符串
        String stringToSign = timestamp + "\n" + secret;
        //使用HmacSHA256算法计算签名
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(stringToSign.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
        byte[] signData = mac.doFinal(new byte[]{});
        return new String(Base64.encodeBase64(signData));
    }
}
