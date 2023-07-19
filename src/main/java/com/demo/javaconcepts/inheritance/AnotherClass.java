package com.demo.javaconcepts.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnotherClass {

    public void accessProtectedMethodOfAnotherClassFromSamePackage() {
        ProtectedClass inheritanceDemo = new ProtectedClass();
        inheritanceDemo.accessProtectedMethodWithoutInheritance();
    }

    public void tryToAccessProtectedDataMemberWithoutInheritanceFromSamePackage() {
        ProtectedClass inheritanceDemo = new ProtectedClass();
        inheritanceDemo.data = 2;
        log.info("Data = {}", inheritanceDemo.data);
    }
}
