package com.demo.reactiveprogramming.reactor;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

@Slf4j
public class MonoDemo {

    public static void main(String[] args) {
        // Mono demo
        Mono<Integer> mono = getMono(1);
        Disposable subscription = mono.subscribe(
                item -> log.info("Received: {}", item),
                throwable -> log.error("Exception: {}", throwable.toString()),
                () -> log.info("onComplete() called"));
        log.info("isDisposed() {}", subscription.isDisposed());

        // Ways of creating mono
        // From .just() method - use it only when we have data ready - gets invoked without subscription
        Mono<String> justMono = Mono.just(getName());

        // From Supplier - gets invoked only when subscribed
        Mono<String> supplierMono = Mono.fromSupplier(MonoDemo::getName);
        supplierMono.subscribe(onNext -> log.info("Result from supplier on subscription: {}", onNext));

        // From Callable - gets invoked only when subscribed
        Mono<String> callableMono = Mono.fromCallable(MonoDemo::getName);
        callableMono.subscribe(onNext -> log.info("Result from callable on subscription: {}", onNext));
    }

    public static String getName() {
        log.info("getName() invoked");
        return Faker.instance().name().fullName();
    }

    private static Mono<Integer> getMono(int i) {
        if (i == 1) {
            return Mono.just(1)
                    .map(ii -> ii * 2);
        } else if (i == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new Throwable("Simulating mono error!"));
        }
    }
}
