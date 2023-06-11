package com.utils;

public abstract class DateTimeUtils {

    public static void sleepSec(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
