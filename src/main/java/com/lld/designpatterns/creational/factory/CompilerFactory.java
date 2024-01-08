package com.lld.designpatterns.creational.factory;

class CompilerFactory {

    public AbstractCompiler getCompiler(String compilerType) {
        if (compilerType.equals("JAVA")) {
            return new JavaCompiler();
        } else if (compilerType.equals("PYTHON")) {
            return new PythonCompiler();
        }
        throw new IllegalArgumentException("No compiler found for type: " + compilerType);
    }
}
