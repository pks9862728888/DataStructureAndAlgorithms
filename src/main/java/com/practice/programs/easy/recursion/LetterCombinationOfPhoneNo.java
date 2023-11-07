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

    private static final Map<Character, String> digitMap = new HashMap<>();

    static {
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
    }

    public List<String> letterCombinationsOfPhoneNumber(String digits) {
        // return notBestApproachInTermsOfSpaceComplexity(digits);
        return betterApproach(digits);
    }

    private List<String> betterApproach(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }
        generate(digits, 0, "", res);
        return res;
    }

    private void generate(String digits, int idx, String wordSoFar, List<String> res) {
        if (idx >= digits.length()) {
            res.add(wordSoFar);
            return;
        }
        char digit = digits.charAt(idx);
        String lettersOfDigit = digitMap.get(digit);
        for (int i = 0; i < lettersOfDigit.length(); i++) {
            String newCombination = wordSoFar + lettersOfDigit.charAt(i);
            generate(digits, idx + 1, newCombination, res);
        }
    }

    private List<String> notBestApproachInTermsOfSpaceComplexity(String digits) {
        List<String> resSoFar = new ArrayList<>();
        if (digits.length() == 0) {
            return resSoFar;
        }
        resSoFar.add("");
        return findCombination(digits, 0, resSoFar);
    }

    private List<String> findCombination(String digits, int idx, List<String> resSoFar) {
        if (idx >= digits.length()) {
            return resSoFar;
        }
        String lettersInDigit = digitMap.get(digits.charAt(idx));
        List<String> newResult = new ArrayList<>(resSoFar.size() * lettersInDigit.length());
        for (String word : resSoFar) {
            for (int i = 0; i < lettersInDigit.length(); i++) {
                newResult.add(word + lettersInDigit.charAt(i));
            }
        }
        return findCombination(digits, idx + 1, newResult);
    }
}
