package com.practice.programs.revise.medium.stack;

import java.util.Stack;

/**
 * TC: O(1) for all operations, AS: O(2n)
 */
public class ImplementMinStack {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> min = new Stack<>();

    static void push(Integer e) {
        stack.push(e);
        if (min.isEmpty()) {
            min.push(e);
        } else {
            if (e.compareTo(min.peek()) >= 0) {
                min.push(min.peek());
            } else {
                min.push(e);
            }
        }
    }

    static void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            min.pop();
        }
    }

    static Integer findMin() {
        if (min.isEmpty()) {
            return -1;
        } else {
            return min.peek();
        }
    }
}
