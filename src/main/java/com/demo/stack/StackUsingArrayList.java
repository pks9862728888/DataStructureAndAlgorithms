package com.demo.stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList<T> implements StackInterface<T> {

    private final List<T> stack;

    public StackUsingArrayList() {
        this.stack = new ArrayList<>();
    }

    @Override
    public void push(T ele) {
        stack.add(ele);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public T peek() {
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
