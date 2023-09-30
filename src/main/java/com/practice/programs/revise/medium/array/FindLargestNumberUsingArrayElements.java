package com.practice.programs.revise.medium.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TC: O(2n + nlog n), AS: O(n)
 */
public class FindLargestNumberUsingArrayElements {

    // 3 30 34 5 9 -> 9534330

    public String largestNumber(int[] nums) {
        List<String> temp = new ArrayList<>();
        boolean isAllDigitZero = true;
        for (int no: nums) {
            temp.add(no + "");
            isAllDigitZero = isAllDigitZero && (no == 0);
        }
        if (isAllDigitZero) {
            return "0";
        }
        Collections.sort(temp, (a, b) -> getComparisonStatus(a, b));
        StringBuilder sb = new StringBuilder();
        for (String no: temp) {
            sb.append(no);
        }
        return sb.toString();
    }

    private int getComparisonStatus(String a, String b) {
        if (a.equals(b)) {
            return 0;
        } else {
            return -1 * (a + b).compareTo(b + a);
        }
    }
}
