package com.interviewconcepts.java.multithreading.racecondition;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class RaceConditionReadModifyRead {

    /**
     * Interleaving of threads occur,
     * first thread reads the value -> gets suspended
     * second thread also reads the value -> gets suspended
     * value gets incremented in thread 1, same value gets incremented in thread 2 resulting in race condition
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(counter);
        Thread thread2 = new Thread(counter);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        log.info("counter: {}", counter.getCount()); // actual answer should have been 20,000
    }

}

@Getter
class Counter implements Runnable {

    private int count;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
            // Fix for race-condition
//            synchronized (this) {
//                count++;
//            }
        }
    }
}