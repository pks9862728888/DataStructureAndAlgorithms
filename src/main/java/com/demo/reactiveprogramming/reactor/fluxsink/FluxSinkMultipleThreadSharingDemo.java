package com.demo.reactiveprogramming.reactor.fluxsink;

import com.github.javafaker.Faker;
import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

@Slf4j
public class FluxSinkMultipleThreadSharingDemo {

    public static void main(String[] args) {
        // Create channel where rescue workers will send missing person name
        MissingPersonFinderChannel channel = new MissingPersonFinderChannel("durable-channel");
        Flux<String> stringFlux = Flux.create(channel);

        // Multiple subscribers who want to get real time updates on missing person
        // TODO: make multiple subscriber logic work
        stringFlux.subscribe(a -> log.info("Received: {} Subscriber: {}", a, 1));

        // Create multiple producers which will publish message to the channel
        // Scenario multiple rescue workers are searching for missing persons
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> IntStream.range(0, 3)
                    .forEach(z -> channel.next(Faker.instance().name().fullName()))).start();
        }

        // Wait for few minutes
        DateTimeUtils.sleepSec(2);
    }
}
