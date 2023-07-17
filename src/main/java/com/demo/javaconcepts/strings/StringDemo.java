package com.demo.javaconcepts.strings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringDemo {

    public static void main(String[] args) {
        String s0 = "hello";
        String s1 = "hello";
        log.info("{}", s0 == s1);

        String s2 = s1.substring(1);
        String s3 = s1.substring(1);
        log.info("substring ==: {}", s2 == s3);
        log.info("substring .equals(): {}", s2.equals(s3));

        log.info("Trims escape chars except escaped single / double quote, slash: {}",
                "h\"\'\\\r\n\f".trim().length());  // 4

        log.info("Idx of: {}", s1.indexOf("l", 3));
        log.info("Idx of: {}", s1.indexOf("l", 20));
        log.info("Idx of: {}", s1.indexOf("l", -1));

    }
}
