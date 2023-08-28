package com.lld.designpatterns.structural.adapter;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class NewEmployeeClass implements EmployeeI {

    private long id;
    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getId() {
        return this.id;
    }
}
