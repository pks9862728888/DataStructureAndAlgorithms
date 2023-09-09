package com.practice.programs.easy.twopointer;

/**
 * TC: O(n + m), AS: O(n + m)
 */
public class MergeTwoSortedArrays {

    public static int [] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[n + m];
        int resP = 0;
        int n1P = 0;
        int n2P = 0;
        while (n1P < n || n2P < m) {
            if (n1P < n && n2P < m) {
                res[resP++] = nums2[n1P] <= nums1[n2P] ? nums2[n1P++] : nums1[n2P++];
            } else if (n1P < n) {
                res[resP++] = nums2[n1P++];
            } else {
                res[resP++] = nums1[n2P++];
            }
        }
        return res;
    }
}
