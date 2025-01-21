package com.saki.designPattern.singleton.extend;

import com.saki.entity.Book;

public class ExtendMain {
    public static void main(String[] args) {
        //生成票编号的单例
        TicketMaker ticketMaker = TicketMaker.getInstance();
        System.out.println(ticketMaker.getNextTicketNumber());
        ticketMaker = TicketMaker.getInstance();
        System.out.println(ticketMaker.getNextTicketNumber());

        //最多生成三个类的实例
        Triple triple = Triple.getInstance(2);
        System.out.println(triple);
        triple = Triple.getInstance(2);
        System.out.println(triple);

        //双重校验锁
        Thread thread1 = new DoubleCheckedLockingSingletonThread();
        Thread thread2 = new DoubleCheckedLockingSingletonThread();
        Thread thread3 = new DoubleCheckedLockingSingletonThread();
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class DoubleCheckedLockingSingletonThread extends Thread{
        @Override
        public void run() {
            Book book = DoubleCheckedLockingSingleton.getInstance();
            System.out.println(book);
        }
    }
}
