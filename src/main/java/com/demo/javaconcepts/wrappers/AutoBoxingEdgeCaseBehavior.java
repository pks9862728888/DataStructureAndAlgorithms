package com.demo.javaconcepts.wrappers;

public class AutoBoxingEdgeCaseBehavior {

    public static void main(String[] args) {
        // No Autoboxing (with small values in byte range (-128 to 127),
        // java does some kind of caching & does not create object)
        Integer i1 = 40;
        Integer i2 = 40;
        System.out.println(i1 == i2);

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
    }
}
