package com.practice.programs.revise.medium.greedyalgorithms;

public class JumpGame1 {

    // from idx i, user, can take upto i, i + 1, i + 2, .... i + nums[i] jumps
    // Find if user can reach end from start
    // 4, 0, 0, 0, 4 -> true
    // 3, 0, 0, 0, 4 -> false
    // Use greedy approach, TC: O(n), AS: O(1)

    public static boolean canReachEndFromStart(int[] nums) {
        int targetNumIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (targetNumIndex <= (i + nums[i])) {
                targetNumIndex = i;
            }
        }
        return targetNumIndex == 0;
    }
}
