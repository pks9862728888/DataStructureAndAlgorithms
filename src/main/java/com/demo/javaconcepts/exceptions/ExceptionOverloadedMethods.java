package com.demo.javaconcepts.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionOverloadedMethods {

    public void abc() throws IOException {}

    public void abc(int i) throws FileNotFoundException {}
}
