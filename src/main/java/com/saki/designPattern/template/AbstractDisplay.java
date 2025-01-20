package com.saki.designPattern.template;

/**
 * 模板方法设计模式
 * 抽象方法由子类实现，模板方法display不变
 * display调用一次open，五次print，最后调用一次close
 * @author saki
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    public final void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
