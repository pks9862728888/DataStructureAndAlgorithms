package com.practice.programs.revise.easy.stack;

import java.util.Stack;

/**
 * TC: (n) AS: O(n)
 * <a href="https://www.codingninjas.com/codestudio/problems/postfix-to-infix_8382386?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class PostfixToInfix {

    public static void main(String[] args) {
        System.out.println(postToInfix("ab+c*de*+")); // (((a + b) * c) + (d + e))
        System.out.println(postToInfix("ab+c+"));     // ((a+b)+c)
    }

    public static String postToInfix(String exp) {
        // Create a stack for storing operands and result of expression
        // For each element in expression
        //    If letter or digit add to stack
        //    If operator
        //        second_ele = pop()
        //        first_ele = pop()
        //        add to stack = (first_ele operator second_ele)
        // When all done, return st.pop()
        Stack<String> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String secondEle = st.pop();
                String firstEle = st.pop();
                st.push("(" + firstEle + ch + secondEle + ")");
            }
        }
        return st.pop();
    }
}
