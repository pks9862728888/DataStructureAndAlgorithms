package com.practice.programs.revise.medium.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindMaximumNumbersInSlidingWindowOfSizeK {

    // 6 2 -4 1 -1 3 4
    // 6 2 1 3 4
    // TC: O(n) + O(n), AS: O(n)

    public static List<Integer> slidingWindowMaximum(int[] arr, int k) {
        List<Integer> windowMax = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            // Remove elements which are out of window k
            while (!q.isEmpty() && q.peek() < i + 1 - k) {
                q.poll();
            }

            // Remove elements which are less than current element
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }

            q.addLast(i);
            if (i + 1 >= k) {
                windowMax.add(arr[q.peek()]);
            }
        }
        return windowMax;
    }
}
