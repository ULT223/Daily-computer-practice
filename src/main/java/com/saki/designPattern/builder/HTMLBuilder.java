package com.saki.designPattern.builder;

import java.io.PrintWriter;

/**
 * 具体的建造者类
 */
public class HTMLBuilder extends Builder{

    private String filename;
    private PrintWriter writer;

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        try {
            writer = new PrintWriter(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //输出头部信息
        writer.println("<html><head><title>" + title + "</title></head><body>");
        //输出标题
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String str) {
        //输出html体中的段落
        writer.write("<p>" + str + "</p>\n");
    }

    @Override
    public void makeItems(String[] items) {
        //输出无序列表的内容
        writer.println("<ul>");
        for (String item : items){
            writer.println("<li>" + item + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {
        //结尾
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult() {
        return filename;
    }
}
