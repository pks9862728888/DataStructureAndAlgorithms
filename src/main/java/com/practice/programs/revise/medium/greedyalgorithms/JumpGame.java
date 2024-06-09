package com.practice.programs.revise.medium.greedyalgorithms;

public class JumpGame {

    // from idx i, user, can take upto i, i + 1, i + 2, .... i + nums[i] jumps
    // Find if user can reach end from start
    // 4, 0, 0, 0, 4 -> true
    // 3, 0, 0, 0, 4 -> false
    // Use greedy approach, TC: O(n), AS: O(1)

    public String canJump(int[] nums) {
        int currIdx = nums.length - 1;
        for (int prevIdx = currIdx - 1; prevIdx >= 0; prevIdx--) {
            if (prevIdx + nums[prevIdx] >= currIdx) {
                currIdx = prevIdx;
            }
        }
        return String.valueOf(currIdx == 0);
    }
}
