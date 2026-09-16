package com.practice.programs.easy.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * TC: O(n * 4^n), length of input string, at max there will be 4 possibilities for each n
 * AS: O(n), n = length of input string - call stack
 */
class LetterCombinationOfPhoneNo {

    private static final Map<Character, List<Character>> charMap = new HashMap<>();

    static {
        charMap.put('2', List.of('a', 'b', 'c'));
        charMap.put('3', List.of('d', 'e', 'f'));
        charMap.put('4', List.of('g', 'h', 'i'));
        charMap.put('5', List.of('j', 'k', 'l'));
        charMap.put('6', List.of('m', 'n', 'o'));
        charMap.put('7', List.of('p', 'q', 'r', 's'));
        charMap.put('8', List.of('t', 'u', 'v'));
        charMap.put('9', List.of('w', 'x', 'y', 'z'));
    }

    public static List<String> phoneKeypadCombination(String digits) {
        List<String> res = new ArrayList<>();
        evaluate(digits, 0, new StringBuilder(), res);
        return res;
    }

    private static void evaluate(String digits, int idx, StringBuilder curr, List<String> res) {
        if (idx == digits.length()) {
            res.add(curr.toString());
            return;
        }
        List<Character> letters = charMap.get(digits.charAt(idx));
        for (Character letter: letters) {
            curr.append(letter);
            evaluate(digits, idx + 1, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
