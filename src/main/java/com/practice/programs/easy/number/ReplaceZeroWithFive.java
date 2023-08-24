package com.practice.programs.easy.number;

public class ReplaceZeroWithFive {

    public static void main(String[] args) {
        int n = 1060;
        int res = 0;
        int multiplier = 1;     // To prevent number from getting reversed

        while (n > 0) {
            int rem = n % 10;    // Find the reminder
            if (rem == 0) {      // Question was to replace all 0 with 5, so we replace 0 with 5
                rem = 5;
            }
            res = res + rem * multiplier;  // Logic to re-construct number without getting reversed
            n /= 10;
            multiplier *= 10;
        }

        System.out.println(res);
    }
}
