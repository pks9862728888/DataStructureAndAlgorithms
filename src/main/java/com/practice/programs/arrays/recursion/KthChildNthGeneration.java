package com.practice.programs.arrays.recursion;

/**
 * Platform: CodingNinjas
 * Question: Find Kth child of Nth generation given that every member gives 2 child-birth
 * and male gives first child as male and the other one female
 * but female gives first child as female and the other one male
 */
public class KthChildNthGeneration {
    public static void main(String[] args) {
        System.out.println(kthChildNthGeneration(2, 2));
        System.out.println(kthChildNthGeneration(3, 4));
        System.out.println(kthChildNthGeneration(40, 26280497));
    }
    private static final String m = "Male";
    private static final String f = "Female";

    public static String kthChildNthGeneration(int n, long k) {
        // First child of any generation will be male
        if (n == 1 || k == 1) {
            return m;
        }
        // Get parent position (K) in (n - 1) generation
        long parK = (long) Math.floor((k + 1) / 2);
        // Get parent gender using recursion
        String parGen = kthChildNthGeneration(n - 1, parK);
        // If child is first child of parent then gender will be same as that of parent else opposite
        if (k == parK * 2 - 1) {
            return parGen;
        } else {
            return parGen.equals(m) ? f : m;
        }
    }
}
