package com.saki.designPattern.adapter.extend;

import java.io.IOException;
import java.util.Map;

public class FileProperties implements FileIO{

    private FileMapPropertiesAdapter fileMapPropertiesAdapter;

    public FileProperties(String filePath) {
        fileMapPropertiesAdapter = new FileMapPropertiesAdapter(filePath);
    }

    @Override
    public void readFromFile(String filename) throws IOException {
        fileMapPropertiesAdapter.load(filename);
    }

    @Override
    public void writeToFile(String filename) throws IOException {
        fileMapPropertiesAdapter.save(filename);
    }

    @Override
    public void setValue(String key, String value) {
        fileMapPropertiesAdapter.setValue(key, value);
    }

    @Override
    public String getValue(String key) {
        return fileMapPropertiesAdapter.getValue(key);
    }
}
