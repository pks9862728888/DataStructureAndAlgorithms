package com.practice.programs.revise.hard.array.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TC: O(2n + log (sum(arr) - max(arr) + 1) * n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/allocate-books_1090540?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class AllocateBooksSuchThatMaxPagesAllocatedToEachStudentIsMinimum {

    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(25, 46, 28, 49, 24));
        System.out.println(findPages(l, l.size(), 2));  // 99
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n) {
            return -1;
        }
        int st = max(arr);
        int end = sum(arr);
        int pagesAllocated = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int studentAllocated = findStudentAllocated(arr, mid);
            if (studentAllocated <= m) {
                // Decrease no of pages, so that more can be allocated
                pagesAllocated = mid;
                end = mid - 1;
            } else {
                // Allocation is not possible, so increase pages so that less allocated
                st = mid + 1;
            }
        }
        return pagesAllocated;
    }

    private static int findStudentAllocated(ArrayList<Integer> arr, int maxPages) {
        int remPages = maxPages;
        int allocatedStudent = 0;
        for (int page : arr) {
            remPages -= page;
            if (remPages == 0) {
                allocatedStudent++;
                remPages = maxPages;
            } else if (remPages < 0) {
                allocatedStudent++;
                remPages = maxPages - page;
            }
        }
        if (remPages != maxPages) {
            allocatedStudent++;
        }
        return allocatedStudent;
    }

    private static int max(ArrayList<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (int e : arr) {
            max = Math.max(max, e);
        }
        return max;
    }

    private static int sum(ArrayList<Integer> arr) {
        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        return sum;
    }
}
