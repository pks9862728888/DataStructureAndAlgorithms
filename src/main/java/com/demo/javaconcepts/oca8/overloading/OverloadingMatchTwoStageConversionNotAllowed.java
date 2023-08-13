package com.demo.javaconcepts.oca8.overloading;

class OverloadingMatchTwoStageConversionNotAllowed {

//    void match(int... arr) {
//        System.out.println("int varargs called: " + arr.length);
//    }

    void match(Integer... arr) {
        System.out.println("Integer varargs called: " + arr.length);
    }

    void match(Integer value) {
        System.out.println("Integer value match: " + value);
    }

    public static void main(String[] args) {
        OverloadingMatchTwoStageConversionNotAllowed ob = new OverloadingMatchTwoStageConversionNotAllowed();
        // Not allowed since 2 stage, int to integer and then varargs, but it will match with int... varargs though
//        ob.match(new int[]{1, 2, 3});
        ob.match(new Integer[]{1, 2, 3});

        // However single stage conversion is allowed
        ob.match(1);
        ob.match(new Integer(2));
    }
}
