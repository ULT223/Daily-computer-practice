package com.saki.designPattern.template;

import lombok.AllArgsConstructor;

/**
 * 子类继承父类，实现具体逻辑
 */
@AllArgsConstructor
public class CharDisplay extends AbstractDisplay{

    private char ch;

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(ch);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
