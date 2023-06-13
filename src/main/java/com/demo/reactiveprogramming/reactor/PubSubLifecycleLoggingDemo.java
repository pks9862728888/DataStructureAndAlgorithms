package com.demo.reactiveprogramming.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class PubSubLifecycleLoggingDemo {

    /**
     * First the main subscription happens
     * then after filter subscription happens
     * then after filter request for unbounded items
     * then filter requests main subscription for unbounded items
     * from mainSubscription all items are emitted, and then onComplete is called for main subscription
     * then onComplete is called for subscription after filter
     */
    public static void main(String[] args) {
        Flux.range(1, 4)
                .log("MAIN_SUBSCRIPTION")
                .filter(i -> i % 2 != 0)
                .log("AFTER_FILTER")
                .subscribe(onNext -> log.info("Received: {}", onNext));
    }
}
