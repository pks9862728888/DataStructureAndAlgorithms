package com.practice.programs.easy.arrays;

/**
 * <a href="https://www.codingninjas.com/codestudio/problems/median-of-two-sorted-arrays_985294?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class FindMedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] {1, 3, 5, 7, 9},
                new int[] {2, 4, 6, 8}, 1, 1));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2 , int m, int n) {
        // return nonOptimalMedian(nums1, nums2, m, n); // TC: O(n) AS: O (n)
        // return betterMedian(nums1, nums2, m, n); // TC: O (n), AS: O(1)
        return optimalMedian(nums1, nums2, m, n); // TC: O(min(log m), min(log n))
    }

    private static double optimalMedian(int[] arr1, int[] arr2, int n1, int n2) {
        if (n1 > n2) {
            return optimalMedian(arr2, arr1, n2, n1);
        }
        int low = 0;
        int high = n1;
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 - 1 >= 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 - 1 >= 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) * 1.0 / 2;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return -1;
    }

    private static double betterMedian(int[] nums1, int[] nums2, int m, int n) {
        int k = m + n;
        if (k % 2 == 0) { // median = (a[(n - 1) / 2] + a[n / 2]) / 2
            return findEvenMedian(nums1, nums2, m, n, (k - 1) / 2, k / 2);
        } else { // median = a[n / 2]
            return findOddMedian(nums1, nums2, m, n, k / 2);
        }
    }

    private static double findEvenMedian(int[] nums1, int[] nums2, int m, int n, int k1, int k2) {
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        int n1 = -1;
        int n2 = -1;
        while (p1 < m || p2 < n) {
            int curr;
            if (p1 < m && p2 < n) {
                curr = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
            } else if (p1 < m) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            if (p == k1) {
                n1 = curr;
            } else if (p == k2) {
                n2 = curr;
                break;
            }
            p++;
        }
        return (n1 + n2) * 1.0 / 2;
    }

    private static double findOddMedian(int[] nums1, int[] nums2, int m, int n, int k) {
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        int curr = -1;
        while (p1 < m || p2 < n) {
            if (p1 < m && p2 < n) {
                curr = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
            } else if (p1 < m) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            if (p == k) {
                return curr;
            }
            p++;
        }
        return curr;
    }

    private static double nonOptimalMedian(int[] nums1, int[] nums2 , int m, int n) {
        int[] res = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m || p2 < n) {
            if (p1 < m && p2 < n) {
                res[p++] = nums1[p1] <= nums2[p2] ? nums1[p1++] : nums2[p2++];
            } else if (p1 < m) {
                res[p++] = nums1[p1++];
            } else {
                res[p++] = nums2[p2++];
            }
        }
        return res.length % 2 == 0 ?
                ((res[(res.length - 1) / 2] + res[res.length / 2]) * 1.0 / 2) :
                res[res.length / 2];
    }
}
