package com.demo.reactiveprogramming.reactor.fluxsynchronoussink;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SynchronousSinkGenerateUntilDemo {

    public static void main(String[] args) {
        // Generate until 10
        Flux.generate(synchronousSink -> {
                    int i = ThreadLocalRandom.current().nextInt(100);
                    synchronousSink.next(i);
                    if (i == 10) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(onNext -> log.info("Received: {}", onNext),
                        onError -> log.error("Exception: {}", onError.toString()));
    }
}
