package com.lld.designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter pattern:
 * Used to adapt legacy code to work with new code when modification to legacy code is not allowed.
 * <p>
 * Pitfall:
 * Do not add new functionality to adapter code.
 * When to use:
 * When new code implements different interface and legacy code does not
 */
class AdapterDemo {

    public static void main(String[] args) {
        List<EmployeeI> employeeIList = new ArrayList<>();
        employeeIList.add(new NewEmployeeClass(1, "New Employee"));
        employeeIList.add(new LegacyEmployeeAdapter(
                new LegacyEmployeeClass(1, "Old Employee", "M")));

        System.out.println(employeeIList);
    }
}
