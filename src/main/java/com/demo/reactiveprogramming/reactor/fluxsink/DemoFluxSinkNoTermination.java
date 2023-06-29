package com.demo.reactiveprogramming.reactor.fluxsink;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class DemoFluxSinkNoTermination {

    // If we remove fluxSink.isCancelled()
    // then create() method will keep on emitting items though subscription is cancelled
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    int i = 1;
                    do {
                        log.info("Emitting: {} Thread: {}", i, Thread.currentThread().getId());
                        fluxSink.next(i++);
                    } while (i <= 10 && !fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(2)
                .subscribe(item -> log.info("Received: {} Thread: {}", item,
                        Thread.currentThread().getId()));
    }
}
