package com.saki.designPattern.iterator.base;

import com.saki.entity.Book;

/**
 * 迭代器设计模式基础测试，Book类为元素
 */
public class IteratorMain {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(5);
        bookShelf.appendBook(new Book("A"));
        bookShelf.appendBook(new Book("B"));
        bookShelf.appendBook(new Book("C"));
        bookShelf.appendBook(new Book("D"));
        bookShelf.appendBook(new Book("E"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
