package com.demo.logging;

import java.util.logging.*;

public class DemoLogging {

    public static void main(String[] args) {
        // Using default logger from LogManager
        LogManager lm = LogManager.getLogManager();
        Logger logger = lm.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO, "What a career!");

        // Creating custom logger
        Logger customLogger = Logger.getLogger("CustomLogger");
        Handler consoleHandler = new ConsoleHandler();
        customLogger.addHandler(consoleHandler);  // adding handler (so in total there will be two handlers now)
        consoleHandler.setFormatter(new SimpleFormatter());  // adding formatter
        customLogger.info("Logging info from custom logger");
    }
}
