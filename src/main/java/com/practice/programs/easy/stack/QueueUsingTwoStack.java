package com.practice.programs.easy.stack;

import java.util.Stack;

/**
 * Push, AS: O(n), TC: O(n)
 * pop(), peek(), empty, TC: O(1)
 */
public class QueueUsingTwoStack {

    private Stack<Integer> st1;
    private Stack<Integer> st2;

    public QueueUsingTwoStack() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        transfer(st1, st2);
        st1.push(x);
        transfer(st2, st1);
    }

    public int pop() {
        if (!st1.isEmpty()) {
            return st1.pop();
        }
        return 0;
    }

    public int peek() {
        if (!st1.isEmpty()) {
            return st1.peek();
        }
        return 0;
    }

    public boolean empty() {
        return st1.isEmpty();
    }

    private void transfer(Stack<Integer> s1, Stack<Integer> s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }
}
