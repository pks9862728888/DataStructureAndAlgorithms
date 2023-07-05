package com.demo.reactiveprogramming.reactor.fluxsynchronoussink;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SynchronousSinkGenerateDemo {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    int i = ThreadLocalRandom.current().nextInt(100);
                    log.info("Emitting: {}", i);
                    synchronousSink.next(i);
                    // We can call next only once, else it will throw exception
                    // However, internally this block of code will be called infinite times till exception / complete
                    // synchronousSink.next(i * 2);
                })
                .take(3)
                .subscribe(onNext -> log.info("Received: {}", onNext),
                        onError -> log.error("Exception: {}", onError.toString()));
    }
}
