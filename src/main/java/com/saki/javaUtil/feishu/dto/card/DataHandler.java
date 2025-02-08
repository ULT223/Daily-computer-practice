package com.saki.javaUtil.feishu.dto.card;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 组装json数据
 */
public class DataHandler {

    /**
     * 获取折线图卡片模板
     * @return
     */
    public static Card getLineGraphFrame(){
        Card card = new Card();
        card.setElements(new ArrayList<Element>());
        // 设置默认卡片标题
        setCardHeader(card,"折线图","blue");
        return card;
    }

    /**
     * 传入模板字符串,设置卡片标题
     * @param card 从该类中获取的JsonObject
     * @param title
     * @param color
     * @return
     */
    public static Card setCardHeader(Card card, String title,String color){
        String header = "{\n" +
                "            \"template\": \"" + color + "\",\n" +
                "            \"title\": {\n" +
                "                \"content\":\"" + title + "\" ,\n" +
                "                \"tag\": \"plain_text\"\n" +
                "            }\n" +
                "        }";
        Header header1 = JSONObject.parseObject(header, Header.class);
        card.setHeader(header1);
        return card;
    }

    public static void addLineGraphElement(Card card,String xCol,String yCol,List<Map<String,Object>> data){
        List<Element> elements = card.getElements();
        Element element = new Element();
        element.setTag("chart");
        JSONObject chartSpec = new JSONObject();
        chartSpec.put("type", "line");

        JSONObject title = new JSONObject();
        title.put("text", "折线图");

        chartSpec.put("title", title);
//        JSONArray xAxis = new JSONArray();
//        for (String x : xCol){
//            xAxis.add(x);
//        }
        chartSpec.put("xField", xCol);
        chartSpec.put("yField", yCol);

        JSONArray values = new JSONArray();
        for (Map<String,Object> map : data){
            values.add(map);
        }

        JSONObject graphData = new JSONObject();
        graphData.put("values", values);

        chartSpec.put("data", graphData);

        element.setChart_spec(chartSpec);
        elements.add(element);
    }
}
