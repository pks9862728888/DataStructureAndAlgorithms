package com.practice.programs.revise.easy.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * TC: O(n) AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/next-greater-element_670312?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class NextGreaterElement {

    public static void main(String[] args) {
        // 12 20 20 -1
        System.out.println(Arrays.toString(nextGreaterElement(new int[] {7, 12, 1, 20}, 4)));
    }

    private static int[] nextGreaterElement(int[] arr, int n) {
        // Create stack for storing the next greater element
        // For each ele in arr traverse in reverse order
        //     while stack is not empty and current ele >= st.top(), delete top element
        //     if stack is not empty and current ele < st.top(), nge = st.top()
        //     add current ele in stack
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            if (!st.isEmpty() && st.peek() > arr[i]) {
                res[i] = st.peek();
            } else {
                res[i] = -1;
            }
            st.push(arr[i]);
        }
        return res;
    }
}
