package com.saki.javaUtil;

import com.alibaba.fastjson.JSONObject;
import com.saki.javaUtil.feishu.constants.MSG_TYPE;
import com.saki.javaUtil.feishu.dto.FeishuPushMessageRequest;
import com.saki.javaUtil.feishu.dto.card.Card;
import com.saki.javaUtil.feishu.dto.card.DataHandler;
import com.saki.javaUtil.feishu.utils.FeishuRobotSender;

import java.util.*;


public class FeishuMain {
    private static final String webhook = "推送地址";

    /**
     * 发送文本消息
     * @param msg
     */
    public static void sendMessage(String msg) {
        FeishuPushMessageRequest feishuPushMessageRequest = new FeishuPushMessageRequest();
        feishuPushMessageRequest.setMsg_type(MSG_TYPE.TEXT.getType());
        String content = "123";
        feishuPushMessageRequest.setContent(content);
        FeishuRobotSender.sendMessage(webhook, feishuPushMessageRequest,"");
    }

    /**
     * 发送卡片消息
     */
    public static void sendCardMessage() {
        FeishuPushMessageRequest feishuPushMessageRequest = new FeishuPushMessageRequest();
        feishuPushMessageRequest.setMsg_type(MSG_TYPE.INTERACTIVE.getType());
        Card card = DataHandler.getLineGraphFrame();
        DataHandler.setCardHeader(card, "测试", "red");

        List<Map<String, Object>> values = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            Map<String, Object> map = new HashMap<>();
            map.put("x", i);
            map.put("y", i * 2);
            values.add(map);
        }

        DataHandler.addLineGraphElement(card, "x", "y", values);
        feishuPushMessageRequest.setCard(card);
        FeishuRobotSender.sendMessage(webhook, feishuPushMessageRequest,"");
    }

    public static void main(String[] args) {
        sendCardMessage();
    }
}
