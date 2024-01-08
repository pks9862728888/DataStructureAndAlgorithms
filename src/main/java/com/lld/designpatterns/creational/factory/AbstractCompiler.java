package com.lld.designpatterns.creational.factory;

abstract class AbstractCompiler {
    abstract boolean compile();
    abstract boolean runTestCases();
    abstract void cleanup();
}
