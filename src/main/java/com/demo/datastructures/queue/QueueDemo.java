package com.demo.datastructures.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
//        QueueInterface<Integer> q = new QueueUsingArray<>();
//        QueueInterface<Integer> q = new QueueUsingLinkedList<>();
        QueueInterface<Integer> q = new CircularQueueUsingArray<>();
        q.add(30);
        System.out.println("SIZE: " + q.size());
        q.add(20);
        System.out.println("FRONT: " + q.peek());
        System.out.println("DEQUEUE: " + q.poll());
        System.out.println("SIZE: " + q.size());
        System.out.println("DEQUEUE: " + q.poll());
        System.out.println("SIZE: " + q.size());

        q.add(10);
        q.add(20);
        q.add(30);
        q.reverse(q);
        System.out.println("Reversed queue: " + q);

        // Java Impl
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
