package com.practice.programs.revise.medium.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class NextGreaterElement {

    /**
     * Expected TC: O(n)
     * Expected AS: O(n)
     * GFG Beginners DSA sheet
     * NGE means next element which is immeditely greater than current element
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextLargerElement(new long[]{1, 3, 2, 4})));
    }

    /**
     * nums1 = elements for which we want to find nge
     * nums2 = full set of elements
     * AS: O(n), TC: O(n + m), where n = no of elements in nums2, m = no of elements in nums1
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            // Find the next greater element
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                nge.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = nge.getOrDefault(nums1[i], -1); // All elements not in hash does not have nge
        }
        return res;
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