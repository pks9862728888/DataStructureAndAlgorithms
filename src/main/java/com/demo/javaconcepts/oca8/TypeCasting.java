package com.demo.javaconcepts.oca8;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class TypeCasting {

    /**
     * CONCEPT:
     * While doing arithmetic operations, java up-casts the operands to the higher data type (numeric promotion)
     */
    public static void main(String[] args) {
        float v1 = 102;
        float v2 = (int) 102;
//        float v3 = 1f * 0.0;  // does not compile because of upcasting of 0.0 to double, so result is double
        float v4 = 1f * (short) 0.0; // short gets upcasted to float
//        float v5 = 1f * (boolean) 0; // Java does not allow conversion of integer values to boolean
    }
}
