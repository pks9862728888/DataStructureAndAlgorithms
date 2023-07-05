package com.demo.reactiveprogramming.reactor.operators;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class HandleOperator {

    public static void main(String[] args) {
        Flux.range(1, 10)
                .handle((item, synchronousSink) -> {  // filter + map
                    if (item % 2 == 0) {
                        synchronousSink.next(item);
                    }
                }).subscribe(item -> log.info("Received: {}", item));
    }
}
