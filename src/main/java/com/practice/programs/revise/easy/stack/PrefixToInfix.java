package com.practice.programs.revise.easy.stack;

import java.util.Stack;

/**
 * TC: O(n), AS: O(n)
 * <a href="https://www.codingninjas.com/studio/problems/prefix-to-infix_1215000?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
public class PrefixToInfix {

    public static void main(String[] args) {
        System.out.println(prefixToInfixConversion("-a+*/bc*def"));  // (a-(((b/c)*(d*e))+f))
    }

    public static String prefixToInfixConversion(String exp) {
        // Reverse string
        // Create stack to store expressions
        // For each element in string
        //  if operand, add to stack
        //  if operator,
        //      se = st.pop(), fe = st.pop()
        //      push to stack: (se operator fe)
        // when everything is done return st.pop()
        Stack<String> st = new Stack<>();
        exp = reverse(new StringBuilder(exp));
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } else {
                String se = st.pop();
                String fe = st.pop();
                st.push("(" + se + ch + fe + ")");
            }
        }
        return st.pop();
    }

    private static String reverse(StringBuilder sb) {
        for (int i = 0; i <= sb.length() / 2; i++) {
            char t = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(sb.length() - i - 1));
            sb.setCharAt(sb.length() - i - 1, t);
        }
        return sb.toString();
    }
}
