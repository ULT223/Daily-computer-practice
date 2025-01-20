package com.saki.designPattern.iterator.extend;

/**
 * 迭代器接口
 */
public  interface Iterator <T> {

    public abstract boolean hasNext();

    public abstract T next();
}
