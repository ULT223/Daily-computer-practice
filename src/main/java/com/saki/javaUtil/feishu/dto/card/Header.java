package com.saki.javaUtil.feishu.dto.card;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

@Data
public class Header {
    /**
     * 颜色模板
     * red
     * orange
     * green
     * blue
     * gray
     */
    private String template;
    /**
     * 元素
     * content: 标题文本
     * tag: 标题标签
     */
    private JSONObject title;
}
