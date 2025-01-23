package com.saki.designPattern.prototype;

/**
 * 抽象原型，定义了方法
 */
public interface Product extends Cloneable{
    public abstract void use(String s);
    public abstract Product createClone();
}
