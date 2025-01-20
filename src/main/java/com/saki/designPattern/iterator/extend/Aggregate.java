package com.saki.designPattern.iterator.extend;

/**
 * 用来创建迭代器类
 */
public interface Aggregate <T>{
    public abstract Iterator<T> iterator();
}
