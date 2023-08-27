package com.practice.programs.revise.easy.stack;

import java.util.Stack;

/**
 * TC: O(n), AS: O(n) -> because we used stack
 * <a href="https://takeuforward.org/data-structure/infix-to-postfix">Explanation</a>
 * <a href="https://takeuforward.org/wp-content/uploads/2023/04/Group-11-5.png">Practice link</a>
 */
public class InfixToPostFix {

    public static void main(String[] args) {
        // Sample 1
        final String exp1 = "(3-2+l/8)-(4+6/3*(5^8))";
        System.out.println(exp1 + " -> " + infixToPostfix(exp1));  // 32-l8/+463/58^*+-

        // Sample 2
        final String exp2 = "((r/f)+(m-b/9))*(y/v-z/5/2)";
        System.out.println(exp2 + " -> " + infixToPostfix(exp2));  // rf/mb9/-+yv/z5/2/-*
    }

    public static String infixToPostfix(String exp) {
        // Iterate over the array
        // If number is encountered add to string
        // If opening bracket is encountered
        //    push to stack
        // If closing bracket is encountered
        //    pop elements and add to result till opening bracket is encountered
        // If operator is encountered,
        //    check if stack is empty
        //        if stack is empty -> push into stack
        //        if stack is not empty
        //            compare with top of stack for precedence
        //                if top of stack is opening bracket
        //                    push in stack
        //                else if precedence of top element is higher than current
        //                    pop operator and to result
        //                else
        //                    push operator to stack
        // When iteration is complete
        //     pop all operators from stack and add to result
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                res.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                popElementsFromStackTillOpeningBracket(res, st);
            } else {  // Operator
                popElementsFromStackTillPrecedenceOfCurrIsLessThanOrEqToTop(
                        ch, st, res);
                st.push(ch);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }

    private static void popElementsFromStackTillPrecedenceOfCurrIsLessThanOrEqToTop(
            char currOperator, Stack<Character> st, StringBuilder res) {
        while (!st.isEmpty() &&
                st.peek() != '(' &&
                getPrecedence(currOperator) <= getPrecedence(st.peek())) {
            res.append(st.pop());
        }
    }

    private static int getPrecedence(char ch) {
        switch (ch) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 3;
        }
    }

    private static void popElementsFromStackTillOpeningBracket(
            StringBuilder sb, Stack<Character> st) {
        char ch;
        while ((ch = st.pop()) != '(') {
            sb.append(ch);
        }
    }
}
