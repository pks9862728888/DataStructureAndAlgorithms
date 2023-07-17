package com.demo.javaconcepts.strings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");
        log.info("{}", sb.replace(0, 1, "B"));
    }
}
