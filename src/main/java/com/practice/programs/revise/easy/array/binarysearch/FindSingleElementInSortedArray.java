package com.practice.programs.revise.easy.array.binarysearch;

import java.util.List;

/**
 * TC: O(log n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/unique-element-in-sorted-array_1112654?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * Intuition:
 * Elements in left of single element will have the first element of pair in even idx
 * Elements in right side of single element will have the first element of pair in odd idx
 * So if mid element is not single element and
 * we are standing at an index of pair while has (evenIdx, oddIdx), eliminate left half, else right half
 */
class FindSingleElementInSortedArray {

    // 1, 1, 2, 2, 4, 5, 5
    // res = 4

    public static int singleNonDuplicate(List<Integer> arr) {
        if (arr.size() == 1) {
            return arr.get(0);
        } else if (!arr.get(0).equals(arr.get(1))) {
            return arr.get(0);
        } else if (!arr.get(arr.size() - 1).equals(arr.get(arr.size() - 2))) {
            return arr.get(arr.size() - 1);
        }
        int st = 1;
        int end = arr.size() - 2;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (!arr.get(mid).equals(arr.get(mid - 1)) &&
                    !arr.get(mid).equals(arr.get(mid + 1))) {
                return arr.get(mid);
            } else if ((mid % 2 == 1 && arr.get(mid).equals(arr.get(mid - 1))) ||
                    (mid % 2 == 0 && arr.get(mid).equals(arr.get(mid + 1)))) {
                st = mid + 1; // eliminate left half
            } else {
                end = mid - 1;  // eliminate right half
            }
        }
        return -1;
    }

}
