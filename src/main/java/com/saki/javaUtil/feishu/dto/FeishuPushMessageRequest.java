package com.saki.javaUtil.feishu.dto;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.saki.javaUtil.feishu.dto.card.Card;

import java.util.HashMap;
import java.util.Map;

/**
 * @author saki
 * 飞书推送消息请求体
 * @date 2021/07/01
 */
public class FeishuPushMessageRequest {
    @JSONField(name = "msg_type")
    private String msg_type;
    @JSONField(name = "content_type")
    private String content_type;

    @JSONField(name = "timestamp")
    private Long timestamp;

    @JSONField(name = "sign")
    private String sign;

    @JSONField(name = "content")
    private Map<String,String> content;

    @JSONField(name = "card")
    private Card card;

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getContent_type() {
        return content_type;
    }

    public void setContent_type(String content_type) {
        this.content_type = content_type;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setContent(String text) {
        if (content == null){
            this.content = new HashMap<>();
        }
        content.put("text",text);
    }

    public Map<String, String> getContent() {
        return content;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
