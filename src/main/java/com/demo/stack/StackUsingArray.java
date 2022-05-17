package com.demo.stack;

import java.util.Arrays;

public class StackUsingArray<T> implements StackInterface<T> {

    private Object[] stack;
    private final int capacity;
    private int currIdx = -1;

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
        if (currIdx + 1 == capacity) {
            doubleCapacity();
        }
        this.stack[++currIdx] = ele;
    }

    private void doubleCapacity() {
        this.stack = Arrays.copyOf(stack, 2 * capacity);
    }

    @Override
    public int size() {
        return currIdx + 1;
    }

    @Override
    public Object peek() {
        if (currIdx == -1) {
            return null;
        } else {
            return stack[currIdx];
        }
    }

    @Override
    public Object pop() {
        if (currIdx == -1) {
            return null;
        } else {
            currIdx--;
            return stack[currIdx + 1];
        }
    }

    @Override
    public boolean isEmpty() {
        return currIdx == -1;
    }
}
