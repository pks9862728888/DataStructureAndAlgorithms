package com.demo.reactiveprogramming.reactor;

import com.github.javafaker.Faker;
import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

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

        // From Future - gets invoked only when subscribed
        // Since its from CompletableFuture, so it runs from ForkJoinPool
        // We will not get the result, so we will have to block it if we want to get result immediately
        Mono<String> futureMono = Mono.fromFuture(() ->
                CompletableFuture.supplyAsync(MonoDemo::getName));
        futureMono.subscribe(onNext -> log.info("Result from future on subscription: {}", onNext),
                onError -> log.error("Error occurred: {}", onError.toString()),
                () -> log.info("From Future is completed!"));
        DateTimeUtils.sleepSec(3);

        // From Runnable - use case to figure out when task was complete
        // It will never call onNext method because runnable returns nothing
        Mono<Object> runnableMono = Mono.fromRunnable(MonoDemo::getName);
        runnableMono.subscribe(onNext -> log.info("No result from runnable on subscription: {}", onNext),
                onError -> log.error("Error occurred: {}", onError.toString()),
                () -> log.info("From Runnable is completed!"));
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
