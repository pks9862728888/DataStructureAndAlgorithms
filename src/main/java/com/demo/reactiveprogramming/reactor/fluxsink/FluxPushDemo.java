package com.demo.reactiveprogramming.reactor.fluxsink;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class FluxPushDemo {

    public static void main(String[] args) {
        Flux.push(FluxPushDemo::getData)  // It is like create, but not thread safe
                .take(10)
                .subscribe(onNext -> log.info("{}", onNext));
    }

    private static void getData(FluxSink<Object> fluxSink) {
        Runnable runnable = () -> fluxSink.next(ThreadLocalRandom.current().nextInt(1, 101));
        for (int i = 1; i <= 10; i++) {
            new Thread(runnable).start();
        }
    }
}
