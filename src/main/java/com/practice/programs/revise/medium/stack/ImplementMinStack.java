package com.practice.programs.revise.medium.stack;

import java.util.Stack;

/**
 * TC: O(1) for all operations, AS: O(2n)
 */
public class ImplementMinStack {
    private static Stack<Integer> st = new Stack<>();
    private static Stack<Integer> minSt = new Stack<>();

    static void push(Integer e) {
        int min = minSt.isEmpty() ? e : Math.min(minSt.peek(), e);
        st.push(e);
        minSt.push(min);
    }

    static void pop() {
        if (!st.isEmpty()) {
            st.pop();
            minSt.pop();
        }
    }

    static Integer findMin() {
        return st.isEmpty() ? -1 : minSt.peek();
    }
}

/**
 * TC: O(1) for all operations, AS: O(n)
 */
class MinStack {

    private static Stack<Integer> st = new Stack<>();
    private static int minEle = Integer.MIN_VALUE;

    static void push(Integer e) {
        if (e < minEle) {
            st.push(2 * e - zeroIfMinValue(minEle));
            minEle = e;
        } else {
            if (st.isEmpty()) {
                minEle = e;
            }
            st.push(e);
        }
    }

    static int pop() {
        if (!st.isEmpty()) {
            int actTopEle = peek();
            if (st.peek() < minEle) {
                minEle = 2 * zeroIfMinValue(minEle) - st.peek();
            }
            if (st.isEmpty()) {
                minEle = Integer.MIN_VALUE;
            }
            return actTopEle;
        }
        return -1;
    }

    static int peek() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek() < minEle ? minEle : st.peek();
    }

    static Integer findMin() {
        return minEle == Integer.MIN_VALUE ? -1 : minEle;
    }

    private static int zeroIfMinValue(int ele) {
        return ele == Integer.MIN_VALUE ? 0 : ele;
    }
}
