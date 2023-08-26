package com.practice.programs.easy.stack;

import java.util.Stack;

// TC: O(length(str)), AS: O(length(str))
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(isValid("([])"));
        System.out.println(isValid("([]]"));
    }

    private static String isValid(String s) {
        // If empty or null string return true
        // Else create an empty stack
        // For each parenthesis,
        // check if its opening parenthesis,
        //  if yes, push to stack
        //  if closing parenthesis
        //      if stack is empty -> return false
        //      if stack is not empty -> pop element and check if closing parenthesis matches
        //        if not return false else continue
        // return true if stack is empty, false otherwise
        if (s == null || s.length() == 0) {
            return "true";
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isOpeningParenthesis(ch)) {
                st.push(ch);
            } else {
                if (st.isEmpty() || !isClosingParenthesisSatisfiesOpening(st.pop(), ch)) {
                    return "false";
                }
            }
        }
        return String.valueOf(st.isEmpty());
    }

    private static boolean isClosingParenthesisSatisfiesOpening(char ch, char valueInStack) {
        switch(ch) {
            case '(':
                return valueInStack == ')';
            case '{':
                return valueInStack == '}';
            case '[':
                return valueInStack == ']';
            default:
                return false;
        }
    }

    private static boolean isOpeningParenthesis(char ch) {
        switch(ch) {
            case '(':
            case '{':
            case '[':
                return true;
            default:
                return false;
        }
    }
}
