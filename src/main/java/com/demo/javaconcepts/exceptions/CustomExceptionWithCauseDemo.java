package com.demo.javaconcepts.exceptions;

public class CustomExceptionWithCauseDemo {

    public static void main(String[] args) {
        try {
            try {
                System.out.println(1 / 0);
            } catch (Exception e) {
                throw new MyException(e.getMessage(), e);
            }
        } catch (MyException e) {
            System.out.println("Exception which we caught: " + e);
            System.out.println("Exception which actually happened: " + e.getCause());
            System.out.println("Stack trace of custom exception points to line no where we wrapped it up but its not correct.");
            e.printStackTrace();
            System.out.println("Stack trace of getCause() gives us the correct location of the exception.");
            e.getCause().printStackTrace();
        }
    }
}
