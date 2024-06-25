package com.practice.programs.revise.hard.segmenttree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinOverARangeAfterUpdates {

    /**
     * Execute q operations on an array
     * Operation 1: u idx valueToUpdate
     * Operation 2: q startIdx endIdx (find min in this range)
     * TC: n log n (for building segTree) + q * log n (where q = no of operations)
     * AS: O(n)
     * Input: 2 3 5 1 9
     * q 0 2
     * u 1 0
     * q 1 4
     * q 3 3
     * Output: 2 0 1
     * Concepts:
     * SEGMENT_TREE
     * SEGMENT_TREE_POINT_UPDATE
     * SEGMENT_TREE_MIN_OVER_RANGE
     */
    public static List<Integer> lilliput(int n, int heights[], int numActions, String actions[]) {
        // Build segment tree
        int[] segTreeArr = new int[4 * n];
        Arrays.fill(segTreeArr, Integer.MAX_VALUE);
        buildSegmentTree(segTreeArr, heights, 0, 0, n - 1);

        // Perform operations on tree
        List<Integer> res = new ArrayList<>();
        for (String action: actions) {
            String[] splitActions = action.split(" ");
            String actionType = splitActions[0];
            int arg1 = Integer.parseInt(splitActions[1]);
            int arg2 = Integer.parseInt(splitActions[2]);

            // Evaluate actions
            if (actionType.equals("u")) {
                pointUpdateSegmentTree(segTreeArr, 0, 0, n - 1, arg1, arg2);
            } else if (actionType.equals("q")) {
                res.add(querySegmentTree(segTreeArr, 0, 0, n - 1, arg1, arg2));
            }
        }
        return res;
    }

    private static void pointUpdateSegmentTree(
            int[] segTreeArr, int currIdx, int l, int h, int targetIdx, int newVal) {
        if (l == h) {
            segTreeArr[currIdx] = newVal;
        } else {
            int mid = (l + h) / 2;
            if (targetIdx <= mid && targetIdx >= l) { // execute update in left half
                pointUpdateSegmentTree(segTreeArr, getLeftChild(currIdx), l, mid, targetIdx, newVal);
            } else { // execute update in right half
                pointUpdateSegmentTree(segTreeArr, getRightChild(currIdx), mid + 1, h, targetIdx, newVal);
            }
            segTreeArr[currIdx] = Math.min(segTreeArr[getLeftChild(currIdx)], segTreeArr[getRightChild(currIdx)]);
        }
    }

    private static int querySegmentTree(int[] segTreeArr, int idx, int l, int h, int ql, int qh) {
        // Check for range
        if (l >= ql && h <= qh) { // complete overlap
            return segTreeArr[idx];
        } else if (l > qh || h < ql) { // no overlap
            return Integer.MAX_VALUE;
        } else { // paritial overlap
            int mid = (l + h) / 2;
            int left = querySegmentTree(segTreeArr, getLeftChild(idx), l, mid, ql, qh);
            int right = querySegmentTree(segTreeArr, getRightChild(idx), mid + 1, h, ql, qh);
            return Math.min(left, right);
        }

    }

    private static void buildSegmentTree(int[] segTreeArr, int[] heights, int idx, int l, int h) {
        if (l == h) {
            segTreeArr[idx] = heights[l];
            return;
        }
        int mid = (l + h) / 2;
        buildSegmentTree(segTreeArr, heights, getLeftChild(idx), l, mid);
        buildSegmentTree(segTreeArr, heights, getRightChild(idx), mid + 1, h);
        segTreeArr[idx] = Math.min(segTreeArr[getLeftChild(idx)], segTreeArr[getRightChild(idx)]);
    }

    private static int getLeftChild(int idx) {
        return 2 * idx + 1;
    }

    private static int getRightChild(int idx) {
        return 2 * idx + 2;
    }
}
