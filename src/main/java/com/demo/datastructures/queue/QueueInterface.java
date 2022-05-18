package com.demo.datastructures.queue;

public interface QueueInterface<T> {

    int size();

    boolean isEmpty();

    void enqueue(T ele);

    T dequeue();

    T front();

}
