package com.practice.programs.easy.number;

import java.util.Stack;

/**
 * TC: O(log n), AS: O(1)
 */
public class DecimalToBinary {

    static int decimalToBinary(int n) {
        Stack<Integer> st = new Stack<>();
        while (n != 0) {
            st.push(n % 2);
            n = n / 2;
        }
        int binary = 0;
        while (!st.isEmpty()) {
            binary = binary * 10 + st.pop();
        }
        return binary;
    }
}
