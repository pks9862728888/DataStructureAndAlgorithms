package com.practice.programs.easy.arrays.binarysearch;

import java.util.List;

/**
 * TC: O(log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/find-peak-element_1081482?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
class FindIdxOfPeakElement {

    // 1 8 1 5 3, ans is 1 or 3
    // If multiple peaks exists, return any one of them

    public static int findPeakElement(List<Integer> arr) {
        int st = 0;
        int end = arr.size() - 1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int left = mid - 1 >= 0 ? arr.get(mid - 1) : -1;
            int right = mid + 1 < arr.size() ? arr.get(mid + 1) : -1;
            if (arr.get(mid) > left && arr.get(mid) > right) {
                return mid;
            } else if (arr.get(mid) < left) { // at least 1 peak exists in left side
                end = mid - 1;
            }  else { // at least 1 peak exists in left side
                st = mid + 1;
            }
        }
        return -1;
    }
}
