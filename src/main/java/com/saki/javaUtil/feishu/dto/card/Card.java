package com.saki.javaUtil.feishu.dto.card;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

@Data
public class Card {
    @JSONField(name = "elements")
    private List<Element> elements;

    @JSONField(name = "header")
    private Header header;
}
