package com.practice.programs.revise.medium.array.votingalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii/description/
 * TC: O(n), AS: O(1)
 * Concepts:
 * ARRAY
 * MOORES_VOTING_ALGORITHM
 * no of majority ele > n / 2 is 1
 * no of majority ele > n / 3 is 2
 * no of majority ele > n / 4 is 3
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        // Find majority element
        int count1 = 0;
        int count2 = 0;
        Integer majEle1 = null;
        Integer majEle2 = null;
        for (int n: nums) {
            if (majEle1 != null && majEle1.equals(n)) {
                count1++;
            } else if (majEle2 != null && majEle2.equals(n)) {
                count2++;
            } else if (count1 == 0) {
                majEle1 = n;
                count1++;
            } else if (count2 == 0) {
                majEle2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        // Determine if the elements are indeed majority element
        int minCount = nums.length / 3;
        count1 = 0;
        count2 = 0;
        for (int n: nums) {
            if (majEle1 != null && majEle1.equals(n)) count1++;
            if (majEle2 != null && majEle2.equals(n)) count2++;
        }
        List<Integer> res = new ArrayList<>();
        if (count1 > minCount) res.add(majEle1);
        if (count2 > minCount) res.add(majEle2);
        return res;
    }
}
