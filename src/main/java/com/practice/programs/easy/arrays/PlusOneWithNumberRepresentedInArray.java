package com.practice.programs.easy.arrays;

import java.util.Arrays;

/**
 * TC: O(n), AS: O(n) if new array is required to be created, else O(1)
 * <a href="https://leetcode.com/problems/plus-one/description/">Practice Link</a>
 */
class PlusOneWithNumberRepresentedInArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{1, 1, 1})));  // 1 1 2
        System.out.println(Arrays.toString(plusOne(new int[]{9})));  // 1 0
        System.out.println(Arrays.toString(plusOne(new int[]{9, 8, 8})));  // 9 8 9
    }

    public static int[] plusOne(int[] arr) {
        int carry = 0;
        int n = arr.length;
        arr[n - 1]++;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > 9) {
                carry = 1;
                arr[i] = 0;
            } else {
                arr[i] = arr[i] + carry;
                carry = arr[i] / 10;
                arr[i] = arr[i] % 10;
            }

            if (carry == 0) {
                break;
            }
        }

        // Return result
        if (carry == 0) {
            return arr;
        } else {
            return appendOneInArrayStart(arr);
        }
    }

    private static int[] appendOneInArrayStart(int[] arr) {
        int[] res = new int[arr.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = arr[i - 1];
        }
        return res;
    }
}
