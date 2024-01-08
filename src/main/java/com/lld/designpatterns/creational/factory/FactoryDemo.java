package com.lld.designpatterns.creational.factory;

class FactoryDemo {

    public static void main(String[] args) {
        CompilerFactory compilerFactory = new CompilerFactory();
        AbstractCompiler javaCompiler = compilerFactory.getCompiler("JAVA");
        javaCompiler.compile();
        javaCompiler.runTestCases();
        javaCompiler.cleanup();
    }
}
