package com.saki.javaUtil.base;

import com.saki.entity.Element;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 测试实现了Dequeue接口的java类
 */
public class MyQueue {


    /**
     * LinkedList实现了Dequeue接口，list接口
     * @return linkedList
     */
    public static LinkedList<Element> testLinkedList(){
        LinkedList<Element> linkedList = new LinkedList<>();
        //从队尾入队
        linkedList.add(Element.builder().id("1").build());
        linkedList.add(Element.builder().id("2").build());
        linkedList.addLast(Element.builder().id("3").build());
        linkedList.addLast(Element.builder().id("4").build());
        linkedList.offer(Element.builder().id("5").build());
        System.out.println("将id为1，2，3,4,5的元素放入队列尾:"+linkedList);
        //从队头入队
        linkedList.addFirst(Element.builder().id("6").build());
        linkedList.addFirst(Element.builder().id("7").build());
        linkedList.addFirst(Element.builder().id("8").build());
        System.out.println("将id为6,7,8的元素加入队列头:" + linkedList);
        //从队头出队列
        linkedList.removeLast();
        Element pop = linkedList.pop();
        System.out.println("pop:从队列" + linkedList +"中取出队头的元素:"+ pop);
        //从队尾出队列
        Element poll = linkedList.poll();
        System.out.println("poll:从队列" + linkedList +"中取出队尾的元素:" + poll);
        Element element = linkedList.pollLast();
        linkedList.remove();
        System.out.println("pollLast:从队列" + linkedList +"中取出队尾的元素:" + element);
        return linkedList;
    }

    /**
     * 阻塞队列练习
     */
    public static void testBlockingQueue(){
        BlockingQueue<Element> arrayDeque = new ArrayBlockingQueue(10, false);
        BlockingQueue<Element> linkedBlockingQueue = new LinkedBlockingQueue(10);
        PriorityBlockingQueue<Element> priorityBlockingQueue = new PriorityBlockingQueue<>();
        for (int i = 0; i < 10; i++)
            arrayDeque.add(Element.builder().id(String.valueOf(i)).build());
        Thread thread1 = new Thread(() -> {
            while (!arrayDeque.isEmpty()){
                try {
                    Thread.sleep(1000);
                    //poll队列空时放弃出队列
                    System.out.println(arrayDeque.poll() + "出队列");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            try {
                Thread.sleep(1000);
                //take方法，当队列为空时，会阻塞
                System.out.println(arrayDeque.take() + "出队列");

                //poll队列空时放弃出队列
                //System.out.println(arrayDeque.poll() + "出队列");

                //remove方法，当队列为空时，会抛出异常
//                System.out.println(arrayDeque.remove() + "出队列");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            int i = 10;
            while (i > 0){
                try {
                    Thread.sleep(1000);
                    //offer方法，当队列满时，会放弃添加
                    //System.out.println("添加元素" + i+ ":" + arrayDeque.offer(Element.builder().id(String.valueOf(i)).build()));

                    //put方法，队列满时，会阻塞
                    arrayDeque.put(Element.builder().id(String.valueOf(i)).build());

                    //add方法，当队列满时，会抛出异常
                    //arrayDeque.add(Element.builder().id(String.valueOf(i)).build());
                    System.out.println("添加元素" + i);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i--;
            }
        });
        thread1.start();
        thread2.start();

    }

    public static void testArrayQueue(){
        Queue<Element> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(Element.builder().id("1").build());
    }

    public static void main(String[] args) {
       testBlockingQueue();
    }
}
