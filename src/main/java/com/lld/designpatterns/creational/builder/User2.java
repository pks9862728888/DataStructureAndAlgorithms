package com.lld.designpatterns.creational.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
@Builder
class User2 {
    private final String name; // Mandatory fields
    private Integer age; // Non-mandatory fields
}
