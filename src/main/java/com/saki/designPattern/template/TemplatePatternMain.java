package com.saki.designPattern.template;

public class TemplatePatternMain {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');
        d1.display();
        AbstractDisplay d2 = new StringDisplay("Hello World");
        d2.display();
        AbstractDisplay d3 = new StringDisplay("你好，世界");
        d3.display();
    }
}
