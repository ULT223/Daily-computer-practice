package com.saki.designPattern.adapter.base;

/**
 * 适配器Adapter(委托的模式)
 * 若为实现接口的模式，print为接口，该Adapter继承Banner，实现Print接口
 * 构造方法调用一下Banner的构造方法，传入字符串，然后在print的接口方法中调用Banner的方法实现适配
 */
public class PrintBanner extends Print{
    private Banner banner;

    public PrintBanner(String string) {
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithAster();
    }

    @Override
    public void printStrong() {
        banner.showWithParen();
    }
}
