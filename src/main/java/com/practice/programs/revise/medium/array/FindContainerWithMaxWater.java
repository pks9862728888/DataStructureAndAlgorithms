package com.practice.programs.revise.medium.array;

/**
 * TC: O(n), AS: O(1)
 * Method: Two pointer
 */
public class FindContainerWithMaxWater {

    // 1 8 6 2 5 4 8 3 7 -> 49 (left most 8 & right most 7 is the container
    // Assume width of bars is negligible and n >= 2

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int currArea = (right - left) * Math.min(height[right], height[left]);
            if (currArea > maxArea) {
                maxArea = currArea;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
}
