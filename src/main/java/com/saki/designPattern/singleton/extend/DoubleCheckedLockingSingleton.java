package com.saki.designPattern.singleton.extend;

import com.saki.entity.Book;

/**
 * 双重校验锁生成book
 */
public class DoubleCheckedLockingSingleton {
    private static volatile Book instance;

    private DoubleCheckedLockingSingleton() {
        System.out.println("DoubleCheckedLockingSingleton");
    }

    public static Book getInstance(){
        if (instance == null){
            synchronized(DoubleCheckedLockingSingleton.class){
                if (instance == null){
                    instance = new Book("DoubleCheckedLockingSingleton");
                }
            }
        }
        return instance;
    }
}
