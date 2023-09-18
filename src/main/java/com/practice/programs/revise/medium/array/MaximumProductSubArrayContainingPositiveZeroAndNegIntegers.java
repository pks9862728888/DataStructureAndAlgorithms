package com.practice.programs.revise.medium.array;

/**
 * TC: O(n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/subarray-with-maximum-product_6890008?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class MaximumProductSubArrayContainingPositiveZeroAndNegIntegers {

    public static int subarrayWithMaxProduct(int []arr){
        int mp = Integer.MIN_VALUE;
        int prefixProd = 1;
        int suffixProd = 1;
        for (int i = 0; i < arr.length; i++) {
            prefixProd *= arr[i];
            suffixProd *= arr[arr.length - i - 1];
            mp = Math.max(mp, Math.max(suffixProd, prefixProd));
            if (prefixProd == 0) {
                prefixProd = 1;
            }
            if (suffixProd == 0) {
                suffixProd = 1;
            }
        }
        return mp;
    }
}
