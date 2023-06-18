package com.demo.reactiveprogramming.reactor;

import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Slf4j
public class FluxDemo {

    public static void main(String[] args) {
        // Ways of creating Flux
        // using just - will get called without any subscription
        Flux<Integer> justFlux = Flux.just(1, 2, 3, 4);
        Flux<Integer> evenFlux = justFlux.filter(i -> i % 2 == 0);
        justFlux.subscribe(
                onNext -> log.info("Received: {}", onNext),
                onError -> log.error("Error: {}", onError.toString()),
                () -> log.info("Completed"));
        evenFlux.subscribe(
                onNext -> log.info("Received: {}", onNext),
                onError -> log.error("Error: {}", onError.toString()),
                () -> log.info("Completed"));

        // using fromIterable() - will get called without any subscription
        Flux<Integer> iterableFlux = Flux.fromIterable(List.of(1, 2));
        iterableFlux.subscribe(onNext -> log.info("Received from iterableFlux: {}", onNext));

        // using fromArray() - will get called without any subscription
        Flux<Integer> fromArrayFlux = Flux.fromArray(new Integer[]{1, 2});
        fromArrayFlux.subscribe(onNext -> log.info("Received fromArrayFlux: {}", onNext));

        // from stream - if we use stream then it can be used only once,
        // so we should use stream supplier instead
        List<Integer> list = List.of(1, 2);
        Flux<Integer> streamFlux = Flux.fromStream(list::stream);
        streamFlux.subscribe(onNext -> log.info("Received fromStream: {}", onNext));

        // from range
        Flux<Integer> rangeFlux = Flux.range(1, 2);
        rangeFlux.subscribe(onNext -> log.info("Received fromRange: {}", onNext));

        // from interval - works in non-blocking way
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(onNext -> log.info("Received from interval: {}", onNext));
        DateTimeUtils.sleepSec(2);

        // From another publisher - mono
        Mono<Integer> mono = Mono.just(1);
        Flux.from(mono)
                .subscribe(onNext -> log.info("Received from flux mono: {}", onNext));

        // Convert flux to mono
        Flux.range(1, 10)
                .next()
                .subscribe(onNext -> log.info("Received only 1 item (): {}", onNext));
    }
}
