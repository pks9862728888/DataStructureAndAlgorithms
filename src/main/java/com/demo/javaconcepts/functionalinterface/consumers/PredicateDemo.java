package com.demo.javaconcepts.functionalinterface.consumers;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Slf4j
public class PredicateDemo {

    public static void main(String[] args) {
        demoUsingInnerClass();
        demoUsingAnonymousClass();
        demoUsingLambda();
    }

    private static void demoUsingLambda() {
        Stream.of(1, 2, 3)
                .filter(i -> i % 2 == 0)
                .forEach(i -> log.info("{}", i));
    }

    private static void demoUsingAnonymousClass() {
        Predicate<Integer> cd = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return ((int) integer) % 2 == 0;
            }
        };
        Stream.of(1, 2, 3).filter(cd).forEach(i -> log.info("{}", i));
    }

    private static void demoUsingInnerClass() {
        class PredicateInner implements Predicate<Integer> {

            @Override
            public boolean test(Integer i) {
                return i % 2 == 0;
            }
        }

        PredicateInner cd = new PredicateInner();
        Stream.of(1, 2, 3).filter(cd).forEach(i -> log.info("{}", i));
    }
}
