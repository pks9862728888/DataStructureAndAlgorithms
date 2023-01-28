package com.demo.algorithms;

/**
 * This algorithm is to find the majority element in array in O(n) time and O(1) AS
 * Step 1: Find the candidate element having possible freq > n / 2
 * Step 2: Validate if the element is the majority element
 */
public class MooresVotingAlgorithm {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 3, 1, 3, 4}, 5));
    }

    static int majorityElement(int[] arr, int n) {
        // Find candidate element
        int candidateEle = findCandidate(arr, n);

        // Return candidate ele if ele is majority else return -1
        return isMajority(arr, n, candidateEle) ? candidateEle : -1;
    }

    private static int findCandidate(int[] arr, int s) {
        int mi = 0, c = 1;
        for (int i = 1; i < s; i++) {
            if (arr[i] == arr[mi]) {
                c++;
            } else {
                c--;
                if (c == 0) {
                    c = 1;
                    mi = i;
                }
            }
        }
        return arr[mi];
    }

    private static boolean isMajority(int[] arr, int n, int candidateElement) {
        int c = 0;
        for (int ele : arr) {
            if (ele == candidateElement) {
                c++;
            }
        }
        return c > n / 2;
    }

}
