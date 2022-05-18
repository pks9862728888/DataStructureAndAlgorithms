package com.demo.datastructures.queue;

public interface QueueInterface<T> {

    int size();

    boolean isEmpty();

    void add(T ele);  // enqueue

    T remove();       // dequeue

    T poll();

    String toString();

    default void reverse(QueueInterface<T> queue) {
        if (!queue.isEmpty()) {
           T ele = queue.remove();
           reverse(queue);
           queue.add(ele);
        }
    }

}
