package com.demo.javaconcepts.oca8.overloading;

class OverloadingMatchVarargs {

    void match(int... arr) {
        System.out.println("Int varargs called: " + arr.length);
    }

    void match(Integer... arr) {
        System.out.println("Integer varargs called: " + arr.length);
    }

    // This is not allowed because varargs of same type is already defined
//    void match(int[] arr) {
//        System.out.println("Integer array varargs called: " + arr.length);
//    }

    public static void main(String[] args) {
        OverloadingMatchVarargs ob = new OverloadingMatchVarargs();
        ob.match(new int[]{1, 2, 3});
        ob.match(new Integer[]{1, 2});
    }
}
