package com.demo.javaconcepts.inheritance;

public class InheritanceDemo {

    public static void main(String[] args) {
        AnotherClass obj = new AnotherClass();
        obj.accessProtectedMethodOfAnotherClassFromSamePackage();
        obj.tryToAccessProtectedDataMemberWithoutInheritanceFromSamePackage();
    }
}
