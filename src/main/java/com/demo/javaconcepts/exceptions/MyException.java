package com.demo.javaconcepts.exceptions;

public class MyException extends Exception {

    MyException(String message, Exception e) {
        super(message, e);
    }
}
