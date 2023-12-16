package com.practice.programs.easy.twopointer;

/**
 * TC: O(log n)
 * <a href="https://www.educative.io/module/page/3jGGjvJlQwOFxNjovBo0p7/5864882417434624/5692837435932672/5610104990859264">Time Complexity analysis</a>
 */
public class IsHappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19));
    }

    public static boolean isHappyNumber(int n) {
        int slow = n;
        int fast = sumOfSquaredDigits(n);
        while (fast != 1 && fast != slow) {
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
        }
        return fast == 1;
    }

    private static int sumOfSquaredDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            n /= 10;
            sum += rem * rem;
        }
        return sum;
    }
}
