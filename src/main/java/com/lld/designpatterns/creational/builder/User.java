package com.lld.designpatterns.creational.builder;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
class User {
    private final String name; // Mandatory fields
    private Integer age; // Non-mandatory fields

    private User(Builder builder) {  // Constructor should be private
        this.name = builder.name;
        this.age = builder.age;
    }

    public static class Builder {
        private final String name;
        private Integer age;

        public Builder(String name) { // In Builder put the mandatory fields in constructor
            this.name = name;
        }

        public Builder age(int age) {
            if (age < 0) { // We can have our own custom field validations
                throw new IllegalArgumentException("Age can not be -ve number: " + age);
            }
            this.age = age;
            return this;
        }

        public User build() {  // build() method creates the actual object
            return new User(this);
        }
    }
}
