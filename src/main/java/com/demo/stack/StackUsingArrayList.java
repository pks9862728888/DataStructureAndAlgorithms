package com.demo.stack;

import java.util.ArrayList;
import java.util.List;

public class StackUsingArrayList<T> {

    private final List<T> stack;

    public StackUsingArrayList() {
        this.stack = new ArrayList<>();
    }

    public void push(T ele) {
        stack.add(ele);
    }

    public int size() {
        return stack.size();
    }

    public T peek() {
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
