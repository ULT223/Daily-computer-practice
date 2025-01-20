package com.saki.designPattern.iterator.extend;

import com.saki.entity.Book;

import java.util.Arrays;
import java.util.List;

/**
 * 迭代器设计模式拓展，传入泛型，长度动态
 */
public class IteratorMain {
    public static void main(String[] args) {
        ObjectShelf<Book> objectShelf = new ObjectShelf<>();
        objectShelf.add(new Book("A"));
        objectShelf.add(new Book("B"));
        objectShelf.add(new Book("C"));
        objectShelf.add(new Book("D"));
        objectShelf.add(new Book("E"));
        Iterator<Book> iterator = objectShelf.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            System.out.println(book.getName());
        }
    }
}
