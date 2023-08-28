package com.lld.designpatterns.structural.adapter;

class LegacyEmployeeAdapter implements EmployeeI {

    private final LegacyEmployeeClass legacyEmployeeClass;

    public LegacyEmployeeAdapter(LegacyEmployeeClass legacyEmployeeClass) {
        this.legacyEmployeeClass = legacyEmployeeClass;
    }

    @Override
    public String getName() {
        return legacyEmployeeClass.getEmployeeName();
    }

    @Override
    public long getId() {
        return legacyEmployeeClass.getId();
    }


    // People might argue that adding new methods is equivalent to adding new functionalities
    // so it becomes decorator pattern instead, but so far we are not adding new behavior
    // and trying to adapt to the interface / abstract class then it's still adapter pattern
    @Override
    public String toString() {
        return "LegacyEmployeeClass{" +
                "id=" + getId() +
                " name=" + getName() +
                '}';
    }
}
