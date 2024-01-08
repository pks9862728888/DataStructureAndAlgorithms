package com.lld.designpatterns.creational.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PythonCompiler extends AbstractCompiler {

    public PythonCompiler() {
        log.info("Generated Python compiler");
    }

    @Override
    boolean compile() {
        return false;
    }

    @Override
    boolean runTestCases() {
        return false;
    }

    @Override
    void cleanup() {}
}
