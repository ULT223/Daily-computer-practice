package com.saki.designPattern.adapter.extend;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileMapPropertiesAdapter {
    private String filePath;
    private Map<String, String> map;

    public FileMapPropertiesAdapter(String filePath){
        this.filePath = filePath;
        map = new HashMap<>();
    }

    public void setValue(String key, String value){
        map.put(key, value);
    }

    public String getValue(String key){
        return map.get(key);
    }

    public void save(String fileName) throws IOException {
        File file = new File(filePath,fileName);
        Writer writer = new FileWriter(file);
        writer.write("#written by FileMapProperties\n");
        writer.write("#" + DateUtil.format(DateUtil.date(), DatePattern.NORM_DATETIME_FORMAT) + "\n");
        for(Map.Entry<String, String> entry : map.entrySet()){
            writer.write(entry.getKey() + "=" + entry.getValue() + "\n");
        }
        writer.close();
    }

    public void load(String fileName) throws IOException {
        File file = new File(filePath,fileName);
        if (!file.exists()){
            return;
        }
        Reader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            String[] split = line.split("=");
            map.put(split[0], split[1]);
        }
        reader.close();
    }
}
