package com.practice.programs.easy.string;

/**
 * TC: O(n), AS: O(n)
 */
public class ReverseWordsInString {

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
}
