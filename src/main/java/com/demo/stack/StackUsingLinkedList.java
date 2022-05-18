package com.demo.stack;

public class StackUsingLinkedList<T> implements StackInterface<T> {

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T> stack;
    private int size;

    public StackUsingLinkedList() {
        size = 0;
        stack = null;
    }

    @Override
    public void push(T ele) {
        Node<T> temp = new Node<>(ele);
        temp.next = stack;
        stack = temp;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stack.data;
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T data = stack.data;
            stack = stack.next;
            size--;
            return data;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
