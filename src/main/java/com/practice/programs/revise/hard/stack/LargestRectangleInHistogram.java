package com.practice.programs.revise.hard.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/description/">Practice link</a>
 */
class LargestRectangleInHistogram {

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(2, 1, 5, 6, 2, 6);  // 10
        System.out.println(largestRectangleBruteforce(l));
        System.out.println(largestRectangleAreaBetter(l.toArray(new Integer[0])));
    }

    // TC: O(n), AS: O(n)
    public static int largestRectangleAreaBetter(Integer[] h) {
        // Using stack
        // Find previous smaller element and store result in array
        // Find next smaller element and store result in array
        // For each element, res (nextSmallerEle - prevSmallerEle + 1) * currEle
        int n = h.length;
        int[] ps = new int[n];
        int[] ns = new int[n];

        // Find previous smaller element
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ps[i] = 0;
            } else {
                ps[i] = st.peek() + 1;
            }
            st.push(i);
        }

        // Find next smaller element
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && h[st.peek()] >= h[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ns[i] = n - 1;
            } else {
                ns[i] = st.peek() - 1;
            }
            st.push(i);
        }

        // Find res
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (ns[i] - ps[i] + 1) * h[i]);
        }
        return res;
    }

    // TC: O(n^2) AS: O(1)
    public static int largestRectangleBruteforce(List<Integer> h) {
        // Bruteforce
        // For each element, find the immediate smallest element idx in left side and right side
        // result = currHeight * (rightIdx - leftIdx + 1);
        int res = 0;
        for (int i = 0; i < h.size(); i++) {
            int lp = i;
            int rp = i;
            while (lp >= 0 && h.get(lp) >= h.get(i)) {
                lp--;
            }
            while (rp < h.size() && h.get(rp) >= h.get(i)) {
                rp++;
            }
            res = Math.max(res, (rp - 1 - (lp + 1) + 1) * h.get(i));
        }

        return res;
    }
}
