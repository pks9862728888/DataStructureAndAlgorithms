package com.practice.programs.revise.easy.stack;

import java.util.Stack;

/**
 * TC: (n) AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/postfix-to-prefix_1788455?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
public class PostfixToPrefix {

    public static void main(String[] args) {
        System.out.println(postfixToPrefix("abc/d*e*-f+"));  // +-a**/bcdef
    }

    public static String postfixToPrefix(String exp) {
        // Create stack for storing the expression
        // For each element in expression
        // If it is letter or digit
        //    add to stack
        // If it is operator
        //    second_ele = st.pop()
        //    first_ele = st.pop()
        //    push to stack = operand first_ele second_ele
        // when end of exp is reached return st.pop()
        Stack<String> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String se = st.pop();
                String fe = st.pop();
                st.push(ch + fe + se);
            }
        }
        return st.pop();
    }
}
