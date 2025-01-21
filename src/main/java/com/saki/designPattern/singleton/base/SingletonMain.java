package com.saki.designPattern.singleton.base;

public class SingletonMain {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        singleton = Singleton.getInstance();
        System.out.println(singleton);
    }
}
