package com.saki.javaUtil.feishu.dto.card;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Element {
    private String tag;

    @JSONField(name = "chart_spec")
    private JSONObject chart_spec;
}
