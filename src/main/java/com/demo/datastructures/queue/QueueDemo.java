package com.demo.datastructures.queue;

public class QueueDemo {

    public static void main(String[] args) {
//        QueueUsingArray<Integer> q = new QueueUsingArray<>();
        QueueUsingLinkedList<Integer> q = new QueueUsingLinkedList<>();
        q.add(30);
        System.out.println("SIZE: " + q.size());
        q.add(20);
        System.out.println("FRONT: " + q.front());
        System.out.println("DEQUEUE: " + q.remove());
        System.out.println("SIZE: " + q.size());
        System.out.println("DEQUEUE: " + q.remove());
        System.out.println("SIZE: " + q.size());

        q.add(10);
        q.add(20);
        q.add(30);
        q.reverse(q);
        System.out.println("Reversed queue: " + q);
    }
}
