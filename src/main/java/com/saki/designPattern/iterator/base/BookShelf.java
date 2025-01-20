package com.saki.designPattern.iterator.base;

import com.saki.entity.Book;


/**
 * 书架类,作为迭代器的容器
 */
public class BookShelf implements Aggregate{
    private Book[] books;
    private int last = 0;
    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int index) {
        return books[index];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);//创建书架迭代器
    }
}
