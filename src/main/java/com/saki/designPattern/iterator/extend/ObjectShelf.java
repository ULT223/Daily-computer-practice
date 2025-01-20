package com.saki.designPattern.iterator.extend;

import java.util.List;

/**
 * 迭代器中元素的集合类，实现获取迭代器接口
 * @param <T>
 */
public class ObjectShelf <T> implements Aggregate<T>{
    private List<T> objects;

    public ObjectShelf(List<T> objects) {
        this.objects = objects;
    }

    /**
     * 添加元素
     * @param t
     */
    public void add(T t) {
        objects.add(t);
    }

    public T get(int index) {
        return objects.get(index);
    }

    public int getLength() {
        return objects.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new ObjectIterator<T>(this);
    }
}
