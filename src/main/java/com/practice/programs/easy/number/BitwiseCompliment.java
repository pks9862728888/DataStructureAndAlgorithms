package com.practice.programs.easy.number;

public class BitwiseCompliment {

    /**
     * TC: O(1), AS: O(1)
     */
    public static int findBitwiseComplement(int n) {
        String binStr = Integer.toBinaryString(n);
        int twoMult = 1;
        int bitwiseComp = 0;
        for (int i = binStr.length() - 1; i >= 0; i--) {
            char ch = binStr.charAt(i) == '0' ? '1' : '0';
            bitwiseComp += (ch - '0') * twoMult;
            twoMult *= 2;
        }
        return bitwiseComp;
    }
}
