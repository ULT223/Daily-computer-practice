package com.saki.javaUtil;

import com.saki.entity.Element;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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

    public static void testArrayQueue(){
        Queue<Element> arrayDeque = new ArrayDeque<>();
        arrayDeque.add(Element.builder().id("1").build());
    }

    public static void main(String[] args) {
        testLinkedList();
    }
}
