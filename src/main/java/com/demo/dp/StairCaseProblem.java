package com.demo.dp;

public class StairCaseProblem {

    public static void main(String[] args) {
        System.out.println(staircase(4));
    }

    /**
     * A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time.
     * Implement a method to count and return all possible ways in which the child can run-up to the stairs.
     * TC: O(n) ?
     * AS: O(n)
     */
	public static long staircase(int n) {
		long[] arr = new long[n + 1];
        return get(n, arr);
	}
    private static long get(int n, long[] arr) {
        if (n == 0) {
            arr[n] = 1;
            return arr[n];
        } else if (n < 0) {
            return 0;
        }
        if (arr[n] == 0) {
            // DP memoization
            arr[n] = get(n - 1, arr) + get(n - 2, arr) + get(n - 3, arr);
        }
        return arr[n];
    }

}