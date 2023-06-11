package com.demo.faker;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FakerDemo {

    public static void main(String[] args) {
        log.info("Ancient GOD: {}", Faker.instance().ancient().god());
        log.info("MD5 crypto: {}", Faker.instance().crypto().md5());
        log.info("Super hero: {}", Faker.instance().superhero().name());
        log.info("Color: {}", Faker.instance().color().name());
        log.info("Address: {}", Faker.instance().address().firstName());
    }
}
