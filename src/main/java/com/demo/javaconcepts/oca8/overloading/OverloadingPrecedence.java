package com.demo.javaconcepts.oca8.overloading;

/**
 * Exact match by type
 * Larger primitive type
 * Autoboxed type
 * Varargs
 */
class OverloadingPrecedence {

//    public void match(int i) {
//        System.out.println("int called: " + i);
//    }

    public void match(long i) {
        System.out.println("long called: " + i);
    }

    public void match(double i) {
        System.out.println("double called: " + i);
    }


    public void match(Integer i) {
        System.out.println("Integer called: " + i);
    }

    public void match(int... i) {
        System.out.println("int varargs called: " + i.length);
    }

    public static void main(String[] args) {
        OverloadingPrecedence o = new OverloadingPrecedence();
        o.match(1);  // Please note that it matches with higher data type instead of autoboxed type
    }
}
