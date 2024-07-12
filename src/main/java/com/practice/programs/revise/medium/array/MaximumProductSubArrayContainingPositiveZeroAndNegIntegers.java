package com.practice.programs.revise.medium.array;

/**
 * TC: O(n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/subarray-with-maximum-product_6890008?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * Intuition:
 * If we multiply 2 +ve no, outcome = +ve
 * If we multiply 2 -ve no, outcome = +ve
 * If we multiply 1 +ve, & 1 -ve, outcome = -ve
 * If we multiply 0, outcome 0
 * So if product is 0 at any stage, we reset the product
 * Keep track of prefix product and suffix product so that if can find the subarray from start and end
 * Test case:
 * -7 1 -2 -9, res = 18 [-2, -9]
 * -7 0 1 -2 -3 0 1 2, res = 6, [1, -2, 3]
 * Concept:
 * PREFIX_PRODUCT
 * SUFFIX_PRODUCT
 * PREFIX_PRODUCT_SUFFIX_PRODUCT
 */
public class MaximumProductSubArrayContainingPositiveZeroAndNegIntegers {

    public static int subarrayWithMaxProduct(int []arr){
        long mp = Integer.MIN_VALUE;
        long prefixProd = 1;
        long suffixProd = 1;
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
        return (int) mp;
    }
}
