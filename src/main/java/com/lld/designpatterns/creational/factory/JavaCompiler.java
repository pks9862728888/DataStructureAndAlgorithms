package com.lld.designpatterns.creational.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class JavaCompiler extends AbstractCompiler {

    public JavaCompiler() {
        log.info("Generated Java compiler");
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
