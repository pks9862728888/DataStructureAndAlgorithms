package com.demo.reactiveprogramming.reactor.operators;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

@Slf4j
public class DoLifecycleOperators {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    IntStream.range(0, 7)
                            .filter(i -> i % 2 == 0)
                            .forEach(fluxSink::next);
                    fluxSink.complete();
                })
                .doFirst(() -> log.info("doFirst 1"))
                .doFirst(() -> log.info("doFirst 2"))  // executed bottom to top since subscriber initiates this
                .doOnSubscribe(subscription -> log.info("Subscription 1 : {}", subscription))  // top to bottom
                .doOnSubscribe(subscription -> log.info("Subscription 2 : {}", subscription))
                .doOnRequest(req -> log.info("doOnRequest 1: {}", req))
                .doOnRequest(req -> log.info("doOnRequest 2: {}", req))  // bottom to top
                .doOnNext(item -> log.info("doOnNext: {}", item))
                .doOnEach(signal -> log.info("doOnEach: {}", signal))
                .doOnDiscard(Object.class, item -> log.info("doOnDiscard: {}", item))
                .doOnError(throwable -> log.info("doOnError: {}", throwable.toString()))
                .doOnCancel(() -> log.info("doOnCancel"))
                .doOnComplete(() -> log.info("doOnComplete"))
                .doOnTerminate(() -> log.info("doOnTerminate"))
                .take(2)
                .subscribe(item -> log.info("Received: {}", item),
                        error -> log.error("Exception: {}", error.toString()),
                        () -> log.info("Completed"));
    }
}
