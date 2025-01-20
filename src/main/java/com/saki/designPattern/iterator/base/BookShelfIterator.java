package com.saki.designPattern.iterator.base;

import com.saki.entity.Book;

public class BookShelfIterator implements Iterator{

    private BookShelf bookShelf;
    private int index;//尾指针

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getLength();
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
