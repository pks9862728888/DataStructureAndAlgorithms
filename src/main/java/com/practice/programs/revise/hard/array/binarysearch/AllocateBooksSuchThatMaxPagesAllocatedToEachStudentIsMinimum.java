package com.practice.programs.revise.hard.array.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TC: O(2n + log (sum(arr) - max(arr) + 1) * n), AS: O(1)
 * <a href="https://www.codingninjas.com/codestudio/problems/allocate-books_1090540?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 * Allocate books in such a way that:
 * 1. Each student gets at least one book.
 * 2. Each book should be allocated to only one student.
 * 3. Book allocation should be in a contiguous manner.
 * Concepts:
 * BINARY_SEARCH
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
        // starting will be max pages in array, else students will not be able to hold book having max page
        int st = max(arr);
        int end = sum(arr); // end will be sum of all pages, when no of student = 1
        int pagesAllocated = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            int studentAllocated = findStudentAllocated(arr, mid);
            if (studentAllocated <= m) {
                // Decrease no of pages, so that no of pages allocated is minimum
                pagesAllocated = mid;
                end = mid - 1;
            } else {
                // Allocation is not possible to all students (no of students required > our student count),
                // so increase pages so that we can allocate books to the students we have
                st = mid + 1;
            }
        }
        return pagesAllocated;
    }

    private static int findStudentAllocated(ArrayList<Integer> arr, int maxPages) {
        int studentPages = 0;
        int allocatedStudent = 1;
        for (int page: arr) {
            if (studentPages + page <= maxPages) { // allocate to curr student
                studentPages += page;
            } else { // can't allocate, allocate to next student
                allocatedStudent++;
                studentPages = page;
            }
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
