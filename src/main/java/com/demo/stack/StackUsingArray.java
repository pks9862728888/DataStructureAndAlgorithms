package com.demo.stack;

import java.util.Arrays;

public class StackUsingArray<T> implements StackInterface<T> {

    private Object[] stack;
    private final int capacity;
    private int topIdx = -1;

    public StackUsingArray() {
        this.capacity = 10;
        this.stack = new Object[capacity];
    }

    public StackUsingArray(int capacity) {
        this.capacity = capacity;
        this.stack = new Object[capacity];
    }

    @Override
    public void push(T ele) {
        if (topIdx + 1 == capacity) {
            doubleCapacity();
        }
        this.stack[++topIdx] = ele;
    }

    private void doubleCapacity() {
        this.stack = Arrays.copyOf(stack, 2 * capacity);
    }

    @Override
    public int size() {
        return topIdx + 1;
    }

    @Override
    public Object peek() {
        if (topIdx == -1) {
            return null;
        } else {
            return stack[topIdx];
        }
    }

    @Override
    public Object pop() {
        if (topIdx == -1) {
            return null;
        } else {
            topIdx--;
            return stack[topIdx + 1];
        }
    }

    @Override
    public boolean isEmpty() {
        return topIdx == -1;
    }
}
