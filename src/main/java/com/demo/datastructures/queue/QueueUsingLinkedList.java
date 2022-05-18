package com.demo.datastructures.queue;


import java.util.LinkedList;

public class QueueUsingLinkedList<T> implements QueueInterface<T> {
    LinkedList<T> ll;

    public QueueUsingLinkedList() {
        ll = new LinkedList<>();
    }

    @Override
    public int size() {
        return ll.size();
    }


    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public void add(T data) {
        ll.addLast(data);
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        } else {
            return ll.removeFirst();
        }
    }

    @Override
    public T poll() {
        if (isEmpty()) {
            return null;
        } else {
            return ll.peekFirst();
        }
    }

    @Override
    public String toString() {
        return ll.toString();
    }
}
