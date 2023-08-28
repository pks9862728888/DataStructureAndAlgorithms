package com.practice.programs.revise.medium.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * TC: O(n) AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/next-greater-element-ii_6212757?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class NextGreaterElementCircularLookup {

    public static void main(String[] args) {
        // 5 -1 4 5 5
        System.out.println(Arrays.toString(nextGreaterElementII(new int[] {1, 5, 3, 4, 2})));
    }

    private static int[] nextGreaterElementII(int []a) {
        // Create a stack to store next greater element
        // Iterate from 2 * length of arr - 1 till 0th idx
        //      For each idx, while value in stack <= curr ele, pop()
        //      If idx < length of array, put top ele of stack as nge if exists else -1
        //      Put current ele in stack
        int[] res = new int[a.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * a.length - 1; i>= 0; i--) {
            while (!st.isEmpty() && st.peek() <= a[i % a.length]) {
                st.pop();
            }
            if (i < a.length) {
                if (!st.isEmpty() && st.peek() > a[i]) {
                    res[i] = st.peek();
                } else {
                    res[i] = -1;
                }
            }
            st.push(a[i % a.length]);
        }
        return res;
    }
}
