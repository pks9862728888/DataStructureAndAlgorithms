package com.practice.programs.revise.medium.stack;

import java.util.Stack;

/**
 * TC: O(n) AS: O(n)
 */
class LongestValidParenthesis {

    // ()(()(()) -> ans = 6

    static int longestValidParentheses(String str) {
        // Create var to store result
        // Create stack to store parenthesis idx
        // If opening bracket -> push curr idx to stack
        // If closing bracket
        //      if stack is empty -> push curr idx to stack
        //      if stack has valid parenthesis -> pop it -> get curr valid parenthesis = curr idx - previous invalid or begin -> update res
        int longestValidParenthesis = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(i);
            } else {
                if (st.isEmpty() || str.charAt(st.peek()) != '(') {
                    st.push(i);
                } else {
                    st.pop();
                    int currLen = i - (st.isEmpty() ? -1 : st.peek());
                    longestValidParenthesis = Math.max(currLen, longestValidParenthesis);
                }
            }
        }
        return longestValidParenthesis;
    }
}
