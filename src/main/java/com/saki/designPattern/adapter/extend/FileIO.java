package com.saki.designPattern.adapter.extend;

import java.io.IOException;

/**
 * 要被适配的接口
 * Adaptee
 */
public interface FileIO {
    public void readFromFile(String filename) throws IOException;
    public void writeToFile(String filename) throws IOException;
    public void setValue(String key, String value);
    public String getValue(String key);
}
