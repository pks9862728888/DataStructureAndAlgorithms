package com.practice.programs.revise.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * If no next permutations are possible, return the least possible permutation
 * TC: O(3N), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/next-greater-permutation_6929564?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
public class NextGreaterPermutation {

    public static void main(String[] args) {
        System.out.println(nextGreaterPermutation(convertToIntArr(123)));  // 132
        System.out.println(nextGreaterPermutation(convertToIntArr(1243))); // 1324
        System.out.println(nextGreaterPermutation(convertToIntArr(321))); // 123
    }

    /**
     * 1243
     * Find idx of digit which is greater than the previous, and store idx of previous digit -> 1
     * Replace the previous digit idx with next digit greater than in right halve -> 1342
     * Reverse the right halve of the idx -> 1324
     */
    public static List<Integer> nextGreaterPermutation(List<Integer> digits) {
        if (digits.size() <= 1) {
            return digits;
        }
        int idxDigitNextGreater = -1;
        for (int i = digits.size() - 1; i > 0; i--) {
            if (digits.get(i) > digits.get(i - 1)) {
                idxDigitNextGreater = i - 1;
                break;
            }
        }
        if (idxDigitNextGreater == -1) {
            reverse(digits, 0);
            return digits;
        } else {
            swap(digits, idxDigitNextGreater, findNextGreaterDigitIdxRightHalve(digits, idxDigitNextGreater));
            reverse(digits, idxDigitNextGreater + 1);
            return digits;
        }
    }

    private static int findNextGreaterDigitIdxRightHalve(List<Integer> digits, int currIdx) {
        for (int i = digits.size() - 1; i > currIdx; i--) {
            if (digits.get(i) > digits.get(currIdx)) {
                return i;
            }
        }
        return currIdx;
    }

    private static void reverse(List<Integer> digits, int stIdx) {
        int endIdx = digits.size();
        for (int i = 0; i < (endIdx - stIdx) / 2; i++) {
            swap(digits, stIdx + i, endIdx - i - 1);
        }
    }

    private static void swap(List<Integer> digits, int idx1, int idx2) {
        if (idx1 != idx2) {
            int temp = digits.get(idx1);
            digits.set(idx1, digits.get(idx2));
            digits.set(idx2, temp);
        }
    }

    private static List<Integer> convertToIntArr(int n) {
        List<Integer> ints = new ArrayList<>();
        while (n > 0) {
            ints.add(0, n % 10);
            n /= 10;
        }
        return ints;
    }
}
