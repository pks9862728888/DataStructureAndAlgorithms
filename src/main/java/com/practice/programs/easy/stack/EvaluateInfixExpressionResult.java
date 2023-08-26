package com.practice.programs.easy.stack;

import java.util.Stack;

/**
 * TC: O(n), AS: O(n)
 * Assume only +, -, * are allowed
 */
public class EvaluateInfixExpressionResult {

    static int postfixExpression(String exp) {
        // For each operand in exp store in stack
        // If operator is encountered, pop 2 elements, perform operation and push to stack
        Stack<Integer> st = new Stack<>();
        for (String s: exp.split("\\s+")) {
            if (isOperator(s)) {
                st.push(operate(st.pop(), st.pop(), s));
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    private static int operate(int b, int a, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }

}
