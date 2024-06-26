package com.practice.programs.revise.hard.segmenttree;

import java.util.ArrayList;
import java.util.List;

public class FindInversions {

    /**
     * Find inversions in an array such that arr[j] < arr[i] where j > i
     * |arr[i]| <= 10^5
     * Input:  3 1 3 1 4
     * Output: 2 0 1 0 0
     * Concepts:
     * SEGMENT_TREE
     * SEGMENT_TREE_SUM_OVER_RANGE
     * SHIFTING
     * Here for each no in array, we have to search over range 0 to ele - 1
     * So at first we search sum over the range.
     * Then we point update that element and update all others in the range.
     * Now the problem is numbers can be -ve, so we will have to shift the element,
     * so range becomes 0 to ele + shift - 1
     */
    public List<Integer> countOfSmallerNumberAfterSelf(int[] nums) {
        int shift = 100005; // To handle -ve numbers
        int low = 0;
        int high = 2 * shift;
        int n = 4 * high;
        int[] segTree = new int[n + 1];

        // Prepare list to store result
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            res.add(0);
        }

        // Iterate over nums from right to left, for each find sum over range
        // Update the sum for the seen element
        for (int i = nums.length - 1; i >= 0; i--) {
            int ele = nums[i] + shift;
            int targetLow = 0;
            int targetHigh = ele - 1;
            int sum = countSmaller(segTree, 0, low, high, targetLow, targetHigh);
            res.set(i, sum);
            pointUpdateSegmentTree(segTree, 0, low, high, ele, 1);
        }

        return res;
    }

    private int countSmaller(int[] segTree, int idx, int low, int high, int tLow, int tHigh) {
        if (low > tHigh || high < tLow) { // No overlap
            return 0;
        } else if (low >= tLow && high <= tHigh) { // Complete overlap
            return segTree[idx];
        } else { // Partial overlap
            int mid = (low + high) / 2;
            int leftSum = countSmaller(segTree, getLeftIdx(idx), low, mid, tLow, tHigh);
            int rightSum = countSmaller(segTree, getRightIdx(idx), mid + 1, high, tLow, tHigh);
            int sum = leftSum + rightSum;
            segTree[idx] = sum;
            return sum;
        }
    }

    private void pointUpdateSegmentTree(int[] segTree, int currIdx, int low, int high, int targetIdx, int value) {
        if (low == high) {
            segTree[currIdx] += value;
        } else {
            int mid = (low + high) / 2;
            if (targetIdx >= low && targetIdx <= mid) { // targetIdx lies in left half
                pointUpdateSegmentTree(segTree, getLeftIdx(currIdx), low, mid, targetIdx, value);
            } else {
                pointUpdateSegmentTree(segTree, getRightIdx(currIdx), mid + 1, high, targetIdx, value);
            }
            segTree[currIdx] = segTree[getLeftIdx(currIdx)] + segTree[getRightIdx(currIdx)];
        }
    }

    private int getLeftIdx(int idx) {
        return 2 * idx + 1;
    }

    private int getRightIdx(int idx) {
        return 2 * idx + 2;
    }
}
