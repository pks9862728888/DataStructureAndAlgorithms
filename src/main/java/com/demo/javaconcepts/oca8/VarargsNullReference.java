package com.demo.javaconcepts.oca8;

public class VarargsNullReference {

    public void count(int... arr) {
        if (arr == null) {
            System.out.println("Arr is null!");
        } else {
            System.out.println("length: " + arr.length);
        }

    }

    public static void main(String[] args) {
        VarargsNullReference obj = new VarargsNullReference();
        obj.count(1, 2, 3);
        obj.count(null);
    }
}
