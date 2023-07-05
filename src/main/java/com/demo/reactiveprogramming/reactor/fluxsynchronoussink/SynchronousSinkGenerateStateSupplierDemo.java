package com.demo.reactiveprogramming.reactor.fluxsynchronoussink;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class SynchronousSinkGenerateStateSupplierDemo {

    public static void main(String[] args) {
        final int N = 4;
        // Generate until 10 or first 4 items or till subscriber stays subscribed
        Flux.generate(() -> 0, (noOfItemsEmitted, synchronousSink) -> {
                    int i = ThreadLocalRandom.current().nextInt(100);
                    synchronousSink.next(i);
                    if (i == 10 || ++noOfItemsEmitted == N) {
                        synchronousSink.complete();
                    }
                    return noOfItemsEmitted;
                })
//                .take(1)
                .subscribe(onNext -> log.info("Received: {}", onNext),
                        onError -> log.error("Exception: {}", onError.toString()));
    }
}
