package com.interviewconcepts.java.multithreading.racecondition;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class RaceConditionConditionalModification {

    public static void main(String[] args) throws InterruptedException {
        Wallet wallet = new Wallet(100);

        Thread upiMandateAutoDebit = new Thread(wallet);
        Thread creditCardBillAutoDebit = new Thread(wallet);

        upiMandateAutoDebit.start();
        creditCardBillAutoDebit.start();
        upiMandateAutoDebit.join();
        creditCardBillAutoDebit.join();

        log.info("Balance after deduction: {}", wallet.getBalance()); // actual amount should have been 50
    }
}

@Slf4j
@Getter
@AllArgsConstructor
class Wallet implements Runnable {

    private int balance;

    @Override
    public void run() {
//        synchronized (this) {
            if (balance >= 100) {
                log.info("Deducting balance, Thread: {}", Thread.currentThread().getId());
                balance -= 50;
            } else {
                log.info("Insufficient balance, Thread: {}", Thread.currentThread().getId());
            }
//        }
    }
}
