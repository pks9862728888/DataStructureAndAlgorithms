package com.demo.stack;

public interface StackInterface<T> {
    void push(T ele);

    int size();

    Object peek();

    Object pop();

    boolean isEmpty();
}
