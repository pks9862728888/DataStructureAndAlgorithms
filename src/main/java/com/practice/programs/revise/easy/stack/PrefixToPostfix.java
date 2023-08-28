package com.practice.programs.revise.easy.stack;

import java.util.Stack;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/codestudio/problems/convert-prefix-to-postfix_8391014?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class PrefixToPostfix {

    public static void main(String[] args) {
        System.out.println(preToPost("-a+*/bc*def")); // abc/de**f+-
    }

    private static String preToPost(String s) {
        // Create stack to store expression
        // Reverse string
        // For each element in string
        //    if operand, add to stack
        //    if operator
        //        se = st.pop(), fe = st.pop()
        //        add to stack, operator fe se
        // return reverse(st.pop())
        Stack<String> st = new Stack<>();
        s = reverse(new StringBuilder(s));
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String se = st.pop();
                String fe = st.pop();
                st.push(ch + fe + se);
            }
        }
        return reverse(new StringBuilder(st.pop()));
    }

    private static String reverse(StringBuilder s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            char t = s.charAt(i);
            s.setCharAt(i, s.charAt(s.length() - i - 1));
            s.setCharAt(s.length() - i - 1, t);
        }
        return s.toString();
    }
}
