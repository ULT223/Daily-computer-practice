package com.saki.designPattern.iterator.extend;

import com.saki.entity.Book;

import java.util.Arrays;
import java.util.List;

/**
 * 迭代器设计模式拓展，传入泛型，长度动态
 */
public class IteratorMain {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(new Book("A"), new Book("B"), new Book("C"), new Book("D"), new Book("E"));
        ObjectShelf<Book> objectShelf = new ObjectShelf<>(books);
        Iterator<Book> iterator = objectShelf.iterator();
        while (iterator.hasNext()){
            Book book = iterator.next();
            System.out.println(book.getName());
        }
    }
}
