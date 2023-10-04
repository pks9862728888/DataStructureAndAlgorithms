package com.practice.programs.revise.medium.stack;

/**
 * <a href="https://www.codingninjas.com/studio/problems/count-of-greater-elements-to-the-right_8365436?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
public class NumberOfNgesTowardsRight {

    public static int[] countGreater(int []arr, int []query) {
        return brute(arr, query);
    }

    /**
     * TC: O(q * n), AS: O(q)
     */
    private static int[] brute(int[] arr, int[] query) {
        int[] res = new int[query.length];
        int idx = 0;
        for (int qidx: query) {
            res[idx++] = findNgeCount(arr, qidx);
        }
        return res;
    }

    private static int findNgeCount(int[] arr, int qidx) {
        int count = 0;
        for (int i = qidx + 1; i < arr.length; i++) {
            if (arr[i] > arr[qidx]) {
                count++;
            }
        }
        return count;
    }
}
