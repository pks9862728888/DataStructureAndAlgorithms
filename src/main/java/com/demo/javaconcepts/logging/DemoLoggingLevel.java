package com.demo.javaconcepts.logging;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DemoLoggingLevel {

    private static final Logger logger = LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
//        logger.setLevel(Level.OFF); // In this case no log messages will be shown
//        logger.setLevel(Level.ALL); // In this case all log messages will be shown
        logger.setLevel(Level.WARNING); // In this case all log messages including & above this level will be shown
        logger.log(Level.SEVERE, "Serious failure!");
        logger.log(Level.WARNING, "Potential problem!");
        logger.log(Level.INFO, "General information!");
        logger.log(Level.CONFIG, "Configuration info!");
        logger.log(Level.FINE, "Generalized developer info!");
        logger.log(Level.FINER, "Detailed developer info!");
        logger.log(Level.FINEST, "Specialized developer info!");
    }
}
