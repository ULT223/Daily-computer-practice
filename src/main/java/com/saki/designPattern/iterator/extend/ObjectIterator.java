package com.saki.designPattern.iterator.extend;

public class ObjectIterator <T> implements Iterator<T> {

    private ObjectShelf<T> objectShelf;
    private int index;

    public ObjectIterator(ObjectShelf<T> objectShelf) {
        this.objectShelf = objectShelf;
    }

    @Override
    public boolean hasNext() {
        return index < objectShelf.getLength();
    }

    @Override
    public T next() {
        return objectShelf.get(index++);
    }
}
