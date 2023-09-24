package com.practice.programs.revise.hard.array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * TC: O(2nlog) n AS: O(n) -> call stack
 * <a href="https://www.codingninjas.com/codestudio/problems/team-contest_6840309?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice link</a>
 */
class TeamContestOrReversePairsProblem {

    // count all possible pairs, such that i < j and A[i] > 2 * A[j]

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 3, 1};
        System.out.println(team(arr, arr.length));   // 3 [(4, 1), (4, 1), (3, 1)]
        System.out.println(Arrays.toString(arr));
    }

    public static int team(int []skill, int n){
        // return brute(skill, n);
        return mergeSortAndFindPairs(skill, 0, n - 1);
    }

    private static int mergeSortAndFindPairs(int[] arr, int st, int end) {
        if (st >= end) {
            return 0;
        }
        int mid = st + (end - st) / 2;
        int pairCount = mergeSortAndFindPairs(arr, st, mid);
        pairCount += mergeSortAndFindPairs(arr, mid + 1, end);
        pairCount += findPairs(arr, st, mid, mid + 1, end);
        merge(arr, st, mid, mid + 1, end);
        return pairCount;
    }

    private static int findPairs(int[] arr, int st1, int end1, int st2, int end2) {
        int pairCount = 0;
        int p2 = st2;
        // If ele from right half of array is less than
        for (int p1 = st1; p1 <= end1; p1++) {
            while (p2 <= end2 && arr[p1] > 2 * arr[p2]) {
                p2++;
            }
            pairCount += p2 - st2;
        }
        return pairCount;
    }

    private static void merge(int[] arr, int st1, int end1, int st2, int end2) {
        int temp[] = new int[end2 - st1 + 1];
        int p1 = st1;
        int p2 = st2;
        int pt = 0;
        while (p1 <= end1 || p2 <= end2) {
            if (p1 <= end1 && p2 <= end2) {
                temp[pt++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
            } else if (p1 <= end1) {
                temp[pt++] = arr[p1++];
            } else {
                temp[pt++] = arr[p2++];
            }
        }
        copy(arr, temp, st1);
    }

    private static void copy(int[] arr, int [] temp, int st) {
        for (int i = 0; i < temp.length; i++) {
            arr[st + i] = temp[i];
        }
    }

    private static int brute(int[] skill, int n) {
        Map<Integer, Integer> skillFreq = new TreeMap<>();
        int teamCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (Map.Entry<Integer, Integer> entry: skillFreq.entrySet()) {
                if (skill[i] > 2 * entry.getKey()) {
                    teamCount += entry.getValue();
                } else {
                    break;
                }
            }
            skillFreq.put(skill[i], skillFreq.getOrDefault(skill[i], 0) + 1);
        }
        return teamCount;
    }
}
