package com.practice.programs.revise.easy.array;

/**
 * TC: O(n) SC: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/rotate-array_1230543?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1">practice link</a>
 */
public class ReverseArrayAntiClockwise {

    public static void main(String args[]) {
        int[] arr = {1, 3, 4, 11, 12, 17};  // 12 17, 1, 3, 4, 11
        int n = arr.length;
        int k = 4;
        if (k >= n) {
            k = k % n;
        }
        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
        for (int i = 0; i < n; i++) {
            if (i == (n - 1)) {
                System.out.println(arr[i]);
            } else {
                System.out.print(arr[i] + " ");
            }
        }
    }

    private static void reverse(int[] arr, int st, int e) {
        for (int i = st, j = 0; i <= (st + e) / 2; i++, j++) {
            int t = arr[i];
            arr[i] = arr[e - j];
            arr[e - j] = t;
        }
    }

}
