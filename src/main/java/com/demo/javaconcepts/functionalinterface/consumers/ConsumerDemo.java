package com.demo.javaconcepts.functionalinterface.consumers;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

@Slf4j
public class ConsumerDemo {

    public static void main(String[] args) {
        demoUsingInnerClass();
        demoUsingAnonymousClass();
        demoUsingLambda();
    }

    private static void demoUsingLambda() {
        Arrays.asList(1, 2, 3).forEach(i -> log.info("{}", i));
    }

    private static void demoUsingAnonymousClass() {
        Consumer<Integer> cd = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                log.info("{}", integer);
            }
        };
        Arrays.asList(1, 2, 3).forEach(cd);
    }

    private static void demoUsingInnerClass() {
        class ConsumerInner<Integer> implements Consumer<Integer> {

            @Override
            public void accept(Integer integer) {
                log.info("{}", integer);
            }
        }

        ConsumerInner<Integer> cd = new ConsumerInner<>();
        Arrays.asList(1, 2, 3).forEach(cd);
    }
}
