package com.projects.stockpriceobserver;

import com.utils.DateTimeUtils;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class ReactiveStockPriceObserverDemo {

    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .map(i -> fetchStockPrice())
                .subscribe(price -> log.info("{}", price),
                        t -> log.error("{}", t.toString()),
                        () -> log.info("Completed!"));
        DateTimeUtils.sleepSec(15);
    }

    private static Integer fetchStockPrice() {
        return ThreadLocalRandom.current().nextInt(-5, 5);
    }
}
