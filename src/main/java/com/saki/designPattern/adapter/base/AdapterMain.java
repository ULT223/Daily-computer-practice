package com.saki.designPattern.adapter.base;

public class AdapterMain {
    public static void main(String[] args) {
        PrintBanner printBanner = new PrintBanner("Hello");
        printBanner.printWeak();
        printBanner.printStrong();
    }
}
