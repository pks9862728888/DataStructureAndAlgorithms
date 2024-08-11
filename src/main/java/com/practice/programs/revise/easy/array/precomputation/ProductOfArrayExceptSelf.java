package com.practice.programs.revise.easy.array.precomputation;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * TC: O(n), AS: O(n)
 * Concepts:
 * PREFIX_PRODUCT_SUFFIX_PRODUCT
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProduct = new int[n];
        int[] suffixProduct = new int[n];
        for (int i = 0; i < n; i++) {
            prefixProduct[i] = get(prefixProduct, i - 1, n) * nums[i];
            suffixProduct[n - i - 1] = get(suffixProduct, n - i, n) * nums[n - i - 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = get(prefixProduct, i - 1, n) * get(suffixProduct, i + 1, n);
        }
        return res;
    }

    private int get(int[] arr, int idx, int n) {
        return idx < 0 || idx >= n ? 1 : arr[idx];
    }
}
