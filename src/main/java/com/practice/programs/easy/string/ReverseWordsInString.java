package com.practice.programs.easy.string;

import java.util.LinkedList;
import java.util.List;

/**
 * TC: O(n), AS: O(n)
 */
class ReverseWordsInString {

    // Multiple spaces should be replaced by only 1 space
    // hello      world -> world hello
    // one -> one

    static String reverseWordsInAString(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder wd = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                if (wd.length() > 0) {
                    sb.append(wd);
                    sb.append(" ");
                    wd.setLength(0);
                }
            } else {
                wd.insert(0, ch);
            }
        }
        if (wd.length() > 0) {
            sb.append(wd);
        }

        return sb.toString().trim();
    }

    /**
     * TC: O(2n), AS: O(n)
     */
    public static String reverseString(String str) {
        // Use variable to
        // Iterate over the string
        // currentchar is '' and word is not empty, add to end of string builder
        List<String> l = new LinkedList<>();
        StringBuilder wd = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                wd.append(ch);
            }
            if ((ch == ' ' || i + 1 == str.length()) && wd.length() > 0) {
                l.add(0, wd.toString());
                wd.setLength(0);
            }
        }
        return String.join(" ", l);
    }
}
