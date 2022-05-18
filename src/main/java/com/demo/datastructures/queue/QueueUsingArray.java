package com.demo.datastructures.queue;

public class QueueUsingArray<T> implements QueueInterface<T> {

    private T[] queue;
    private int front = -1;
    private int rear = -1;
    private int size = 0;

    public QueueUsingArray() {
        queue = (T[]) new Object[1];
    }

    public QueueUsingArray(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T ele) {
        if (rear + 1 == queue.length) {
            refactorQueueAndDoubleCapacity();
        }
        queue[++rear] = ele;
        size++;
        if (front == -1) {
            front++;
        }
    }

    private void refactorQueueAndDoubleCapacity() {
        T[] arr = (T[]) new Object[queue.length * 2];
        int st = -1;
        for (int i = front; i <= rear; i++) {
            arr[++st] = queue[i];
        }
        front = 0;
        rear = st;
        queue = arr;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            T ele = queue[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
            size--;
            return ele;
        }
    }

    @Override
    public T front() {
        return isEmpty() ? null : queue[front];
    }
}
