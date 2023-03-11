package com.demo.javaconcepts.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggingMethodsDemo {

    private static final Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    static {
        logger.setLevel(Level.ALL);
    }

    public static void main(String[] args) {
        // Standard Logging method
        logger.log(Level.INFO, "This is standard logging method");

        // Level convenience logging method
        logger.info("Level convenience info method");

        // Precise logging method to get precise calling info in log
        logger.logp(Level.INFO, "com.demo.logging.ClassName", "main", "Precise logging msg");

        // Precise convenience method (always logged as finer level so might not log the message)
        new LoggingMethodsDemo().demoPreciseConvenienceMethodLogging();

        // Parameterized logging methods
        Object[] params = {1, "One"};
        logger.log(Level.INFO, "{0} is the numeric value for {1}", params);
        logger.logp(Level.INFO, "com.demo.logging.ClassName", "main", "{0} = {1}", params);
        logger.entering("className", "methodName", params);
    }

    void demoPreciseConvenienceMethodLogging() {
        logger.entering(LoggingMethodsDemo.class.getName(), "methodName()");
        // Do some work here
        logger.exiting(LoggingMethodsDemo.class.getName(), "methodName()");
    }
}
