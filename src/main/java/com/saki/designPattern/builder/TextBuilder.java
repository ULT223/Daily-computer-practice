package com.saki.designPattern.builder;

/**
 * 具体的建造者类
 */
public class TextBuilder extends Builder{

    private StringBuffer buffer = new StringBuffer();//保存文档内容

    @Override
    public void makeTitle(String title) {//纯文本标题
        buffer.append("===========================\n");//装饰线
        buffer.append("『" + title + "』\n");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("■" + str + "\n");
        buffer.append("\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items){
            buffer.append("　・" + item + "\n");
        }
    }

    @Override
    public void close() {
        buffer.append("===========================\n");
    }

    public String getResult(){
        return buffer.toString();
    }
}
