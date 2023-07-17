package com.demo.reactiveprogramming.reactor;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class FluxCustomSubscriptionDemo {

    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 40)
                .log("MAIN_SUB")
                .subscribeWith(getCustomSubscription(atomicReference));

        // Request to emit items (till items are requested, no items will be emitted)
        Subscription subscription = atomicReference.get();
        subscription.request(3);
        subscription.request(3);
        subscription.cancel();

        // After cancellation if we request for more items no more items will get emitted
        subscription.request(3);
    }

    private static Subscriber<Integer> getCustomSubscription(
            AtomicReference<Subscription> atomicReference) {
        return new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                log.info("onSubscribe() called");
                atomicReference.set(subscription);
            }

            @Override
            public void onNext(Integer integer) {
                log.info("Received: {}", integer);
            }

            @Override
            public void onError(Throwable throwable) {
                log.error("Exception: {}", throwable.toString());
            }

            @Override
            public void onComplete() {
                log.info("onComplete() called");
            }
        };
    }
}
