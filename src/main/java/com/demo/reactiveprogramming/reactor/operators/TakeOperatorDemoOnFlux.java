package com.demo.reactiveprogramming.reactor.operators;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class TakeOperatorDemoOnFlux {

    public static void main(String[] args) {
        Flux.range(0, 10)
                .log()
                .take(2)
                .log()
                .subscribe(onNext -> log.info("Received: {}", onNext),
                        onError -> {},
                        () -> log.info("complete!"));
    }
}
