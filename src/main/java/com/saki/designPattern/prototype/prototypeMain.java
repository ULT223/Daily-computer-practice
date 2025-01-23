package com.saki.designPattern.prototype;

/**
 * 原型模式，
 * 向管理器中注册具体原型，之后只需要调用管理器的create方法即可
 * 会创建一个具体原型的浅克隆
 */
public class prototypeMain {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.register("underLine", new UnderlinePen('~'));
        manager.register("warning box", new MessageBox('*'));
        manager.register("slash box", new MessageBox('/'));
        Product strong = manager.create("underLine");
        strong.use("Hello,world.");
        Product box = manager.create("warning box");
        box.use("Hello,world.");
        Product slash = manager.create("slash box");
        slash.use("Hello,world.");
    }
}
