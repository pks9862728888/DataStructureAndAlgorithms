package com.demo.datastructures.queue;

public class CircularQueueUsingArray<T> implements QueueInterface<T> {

    private T[] queue;
    private int front = -1;
    private int rear = -1;
    private int size = 0;

    public CircularQueueUsingArray() {
        queue = (T[]) new Object[1];
    }

    public CircularQueueUsingArray(int capacity) {
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
    public void add(T ele) {
        if (size() == queue.length) {
            refactorQueueAndDoubleCapacity();
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = ele;
        size++;
        if (front == -1) {
            front++;
        }
    }

    private void refactorQueueAndDoubleCapacity() {
        T[] arr = (T[]) new Object[queue.length * 2];
        int st = -1;
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                arr[++st] = queue[i];
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                arr[++st] = queue[i];
            }
            for (int i = 0; i <= rear; i++) {
                arr[++st] = queue[i];
            }
        }
        front = 0;
        rear = st;
        queue = arr;
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        } else {
            T ele = queue[front];
            size--;
            if (isEmpty()) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % queue.length;
            }
            return ele;
        }
    }

    @Override
    public T peek() {
        return isEmpty() ? null : queue[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        if (!isEmpty()) {
            if (rear >= front) {
                for (int i = front; i <= rear; i++) {
                    sb.append(queue[i]).append(", ");
                }
            } else {
                for (int i = front; i < queue.length; i++) {
                    sb.append(queue[i]).append(", ");
                }
                for (int i = 0; i <= rear; i++) {
                    sb.append(queue[i]).append(", ");
                }
            }
        }
        sb.append("]");
        return sb.toString().replace(", ]", "]");
    }
}
