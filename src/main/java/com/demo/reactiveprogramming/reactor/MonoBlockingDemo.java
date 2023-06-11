package com.demo.reactiveprogramming.reactor;

import com.github.javafaker.Faker;
import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class MonoBlockingDemo {

    public static void main(String[] args) {
        // Since mono was created from Supplier so Mono gets created but it does not get executed
        getName();
        getName();
        getName();

        // If we want to block mono, then either we can subscribe or we can block it
        String name = getName().block();
        getName();
        log.info("Name from blocked mono: {}", name);
    }

    public static Mono<String> getName() {
        log.info("getName() invoked: {}", Thread.currentThread().getId());
        return Mono.fromSupplier(() -> {
                    log.info("Started getting name: {}", Thread.currentThread().getId());
                    DateTimeUtils.sleepSec(2);
                    log.info("Woke up from getting name: {}", Thread.currentThread().getId());
                    return Faker.instance().name().fullName();
                })
                .map(String::toUpperCase);
    }
}
