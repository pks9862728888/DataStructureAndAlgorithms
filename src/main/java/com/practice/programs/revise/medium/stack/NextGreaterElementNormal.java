package com.practice.programs.revise.medium.stack;

import java.util.Stack;

public class NextGreaterElementNormal {

    /**
     * Find next greater element
     * TC: O(n), AS: O(n)
     * Input: 8 2 5 10 4
     * output: 2 -1 4 4 -1
     * Concepts:
     * STACK
     * NEXT_GREATER_ELEMENT
     */
    static int[] nextGreaterElement(int arr[], int n) {
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            while (!st.isEmpty() && st.peek() >= curr) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(curr);
        }
        return res;
    }
}
