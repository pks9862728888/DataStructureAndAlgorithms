package com.practice.programs.easy.arrays;

import java.util.Arrays;

/**
 * TC: O(3n), AS: O(3n)
 */
public class FindProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productOfArrayExceptSelf(new int[]{-1, 1, 0})));
    }

    static int[] productOfArrayExceptSelf(int[] arr) {
        // Store left prefix prod and right prefix prod
        int[] leftProdArr = new int[arr.length];
        int[] rightProdArr = new int[arr.length];
        int leftProd = 1;
        int rightProd = 1;
        for (int i = 0; i < arr.length; i++) {
            leftProdArr[i] = leftProd;
            rightProdArr[arr.length - i - 1] = rightProd;
            leftProd *= arr[i];
            rightProd *= arr[arr.length - i - 1];
        }

        // Calculate prod
        int[] res = new int[arr.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = leftProdArr[i] * rightProdArr[i];
        }
        return res;
    }
}
