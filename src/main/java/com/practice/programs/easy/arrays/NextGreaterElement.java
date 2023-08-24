package com.practice.programs.easy.arrays;

import java.util.Arrays;
import java.util.Stack;

class NextGreaterElement {

    /**
     * Expected TC: O(n)
     * Expected AS: O(n)
     * GFG Beginners DSA sheet
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextLargerElement(new long[]{1, 3, 2, 4})));
    }

    public static long[] nextLargerElement(long[] arr) {
        Stack<Integer> st = new Stack<>();  // Stores indexes
        long[] res = new long[arr.length];

        // Iterate through each ele and populate greater element
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }

        // Populate result till no next greater element was found
        while (!st.isEmpty()) {
            res[st.pop()] = -1;
        }

        return res;
    }
}