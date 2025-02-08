package com.saki.javaUtil.feishu.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 飞书返回的响应
 * @author saki
 */
@Data
public class FeishuPushMessageResponse {
    @JSONField(name = "code")
    private String code;
    @JSONField(name = "msg")
    private String msg;
    @JSONField(name = "data")
    private String data;
    @JSONField(name = "status_message")
    private String status_message;
    @JSONField(name = "status_code")
    private String status_code;
}
