package com.saki.designPattern.adapter.extend;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class FileProperties extends Properties implements FileIO{

    private String filePath;

    public FileProperties(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        load(new FileReader(new File(filePath , filename)));
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        store(new FileWriter(new File(filePath , filename)), "Written By FileProperties");
    }

    @Override
    public void setValue(String key, String value) {
        setProperty(key, value);
    }

    @Override
    public String getValue(String key) {
        return getProperty(key);
    }
}
