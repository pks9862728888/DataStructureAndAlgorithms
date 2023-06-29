package com.demo.reactiveprogramming.reactor.fluxsink;

import com.github.javafaker.Faker;
import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

@Slf4j
public class FluxSinkMultipleThreadSharingDemo {

    public static void main(String[] args) {
        // Create fluxSink where rescue workers will send missing person name
        MissingPersonFinderChannel fluxSink = new MissingPersonFinderChannel("durable-fluxSink");
        Flux<String> stringFlux = Flux.create(fluxSink);

        // Multiple subscribers who want to get real time updates on missing person
        // TODO: make multiple subscriber logic work
        stringFlux
                .take(1)
                .subscribe(a -> log.info("Thread: {} Subscriber: {} Received: {}",
                        Thread.currentThread().getId(), 1, a),
                        onError -> {},
                        () -> log.info("onComplete()"));

        // Create multiple producers which will publish message to the fluxSink
        // Scenario multiple rescue workers are searching for missing persons
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            new Thread(() -> IntStream.range(0, 3)
                    .forEach(z -> {
                        String item = Faker.instance().name().fullName();
                        log.info("Thread: {} publisher: {} Emitting: {}", Thread.currentThread().getId(), finalI, item);
                        fluxSink.next(item);
                    })).start();
        }

        // Wait for few minutes
        DateTimeUtils.sleepSec(2);
    }
}
