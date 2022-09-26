package com.demo.datastructures.stack.algorithms;

import java.util.Stack;

/**
 * Push TC: O(1)
 * Pop TC: O(1)
 * Min Ele TC: O(1)
 */
public class StackInO1 {

    private int minEle;
    private Stack<Integer> stack = new Stack<>();

    public int getMinEle() {
        return stack.isEmpty() ? -1 : minEle;
    }

    public void push(int ele) {
        if (stack.isEmpty()) {
            stack.push(ele);
            minEle = ele;
        } else if (ele >= minEle) {
            stack.push(ele);
        } else {
            stack.push(2 * ele - minEle);
            minEle = ele;
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int ele = stack.pop();
        if (ele < minEle) {
            int actualEle = minEle;
            minEle = 2 * minEle - ele;
            return actualEle;
        }
        return ele;
    }

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        int ele = stack.peek();
        return Math.max(ele, minEle);
    }
}
