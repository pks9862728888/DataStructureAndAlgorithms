package com.practice.programs.revise.medium.array.twopointer;

/**
 * https://www.educative.io/courses/grokking-coding-interview/sort-colors
 * TC: O(n), AS: O(1)
 * Approach: Use Dutch National Flag Algorithm
 * Concept: THREE_POINTER
 */
public class SortColors {

    public static int[] sortColors(int[] colors) {
        int lenColorsArr = colors.length;
        int start = 0;
        int curr = 0;
        int end = lenColorsArr - 1;
        while (curr <= end) {
            int currColor = colors[curr];
            if (currColor == 0) {
                swap(start, curr, colors);
                start++;
                curr++;
            } else if (currColor == 1) {
                curr++;
            } else {
                swap(curr, end, colors);
                end--;
            }
        }
        return colors;
    }

    private static void swap(int idx1, int idx2, int[] arr) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
