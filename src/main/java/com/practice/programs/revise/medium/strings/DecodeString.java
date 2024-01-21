package com.practice.programs.revise.medium.strings;

import java.util.Stack;

public class DecodeString {

    // 3[a2[c]] = accaccacc

    static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ']') {
                StringBuilder repeatedSeq = getRepeatedSeq(st);
                int times = getTimesToRepeat(st);
                for (int j = 0; j < times; j++) {
                    for (int k = repeatedSeq.length() - 1; k >= 0; k--) {
                        st.push(repeatedSeq.charAt(k));
                    }
                }
            } else {
                st.push(ch);
            }
        }

        return constructString(st);
    }

    private static String constructString(Stack<Character> st) {
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    private static int getTimesToRepeat(Stack<Character> st) {
        int times = 0;
        int multiplier = 1;
        while (!st.isEmpty()) {
            char ch = st.peek();
            if (Character.isDigit(ch)) {
                times += (ch - '0') * multiplier;
                multiplier *= 10;
                st.pop();
            } else {
                break;
            }
        }
        return times;
    }

    private static StringBuilder getRepeatedSeq(Stack<Character> st) {
        StringBuilder sb = new StringBuilder();
        char ch;
        while ((ch = st.pop()) != '[') {
            sb.append(ch);
        }
        return sb;
    }
}
