package com.demo.javaconcepts.inheritance.subpackage;

import com.demo.javaconcepts.inheritance.ProtectedClass;

public class AccessFromSubPackage {

    public void tryToAccessProtectedMethodFromAnotherPackageWithoutInheriting() {
        ProtectedClass protectedClass = new ProtectedClass();
//        protectedClass.accessProtectedMethodWithoutInheritance(); // Not allowed
    }
}
