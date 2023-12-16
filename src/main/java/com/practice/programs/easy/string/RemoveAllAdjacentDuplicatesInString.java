package com.practice.programs.easy.string;

import java.util.Stack;

/**
 * TC: O(n), AS: O(n)
 */
public class RemoveAllAdjacentDuplicatesInString {

    public static String removeDuplicates(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (st.isEmpty()) {
                st.push(ch);
            } else {
                if (st.peek() == ch) {
                    st.pop();
                } else {
                    st.push(ch);
                }
            }
        }
        return constructString(st);
    }

    private static String constructString(Stack<Character> st) {
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        reverse(sb);
        return sb.toString();
    }

    private static void reverse(StringBuilder sb) {
        int n = sb.length();
        for (int i = 0; i < n / 2; i++) {
            char temp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(n - i - 1));
            sb.setCharAt(n - i - 1, temp);
        }
    }
}
