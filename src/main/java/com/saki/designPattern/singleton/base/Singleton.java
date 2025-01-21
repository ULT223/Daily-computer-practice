package com.saki.designPattern.singleton.base;

/**
 * 单例模式
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {
        System.out.println("Singleton is created");
    }

    public static Singleton getInstance() {
        return instance;
    }
}
