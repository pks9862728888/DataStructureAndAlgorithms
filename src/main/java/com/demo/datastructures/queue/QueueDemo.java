package com.demo.datastructures.queue;

public class QueueDemo {

    public static void main(String[] args) {
        QueueUsingArray<Integer> q = new QueueUsingArray<>();
        q.enqueue(30);
        System.out.println("SIZE: " + q.size());
        q.enqueue(20);
        System.out.println("FRONT: " + q.front());
        System.out.println("DEQUEUE: " + q.dequeue());
        System.out.println("SIZE: " + q.size());
        System.out.println("DEQUEUE: " + q.dequeue());
        System.out.println("SIZE: " + q.size());
    }
}
