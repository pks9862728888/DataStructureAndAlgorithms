package com.demo.datastructures.queue;

public interface QueueInterface<T> {

    int size();

    boolean isEmpty();

    void add(T ele);  // enqueue

    T poll();       // dequeue

    T peek();

    String toString();

    default void reverse(QueueInterface<T> queue) {
        if (!queue.isEmpty()) {
           T ele = queue.poll();
           reverse(queue);
           queue.add(ele);
        }
    }

}
