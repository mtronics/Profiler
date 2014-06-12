package com.mtronicsDev.profiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Logger {

    public static enum LogLevel { ALL, INFO, WARNING, ERROR, CRITICAL, DEBUG }

    private static PrintWriter filteredLogWriter;
    private static PrintWriter fullLogWriter;
    private static LogLevel currentLogLevel;

    static void initialize() {

        File logDirectory = new File("log");
        if (logDirectory.mkdir())
            System.out.println("[" + TimeHelper.getCurrentDateAndTime() + "][" + LogLevel.INFO.toString() + "][Logger]Created folder: " + logDirectory.getAbsolutePath());
        File filteredLog = new File("log/filtered.log");
        File fullLog = new File("log/full.log");

        try {
            filteredLogWriter = new PrintWriter(filteredLog);
            fullLogWriter = new PrintWriter(fullLog);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    static void stop() {

        filteredLogWriter.close();
        fullLogWriter.close();

    }

    static void setLogLevel(LogLevel logLevel) {

        currentLogLevel = logLevel;

    }

    static void log(String message, String processName, LogLevel logLevel) {

        String logLine = "[" + TimeHelper.getCurrentDateAndTime() + "][" + logLevel.toString() + "][" + processName + "] " + message;

        fullLogWriter.println(logLine);
        if(logLevel.ordinal() >= currentLogLevel.ordinal()) filteredLogWriter.println(logLine);
        System.out.println(logLine);

    }

}
