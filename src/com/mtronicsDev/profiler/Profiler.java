package com.mtronicsDev.profiler;

public class Profiler {

    static boolean running = false;
    private static Thread updateLoop;

    public static void startProfiler(Logger.LogLevel logLevel) {

        running = true;
        updateLoop = new Thread(new Runnable() {
            @Override
            public void run() {

                while (Profiler.running) {
                    ProcessRegistry.updateAll();
                }

                Profiler.updateLoop.interrupt();
            }
        });

        Logger.initialize();
        Logger.setLogLevel(logLevel);
        updateLoop.start();
        Logger.log("Started profiler", "Profiler", Logger.LogLevel.INFO);

    }

    public static void stopProfiler() {
        running = false;
        Logger.log("Stopped profiler", "Profiler", Logger.LogLevel.INFO);
        Logger.stop();
    }

    public static void start(String name) {
        Process process = new Process(name);
        process.start();
        ProcessRegistry.addProcess(name, process);
    }

    public static void stop(String name) {
        ProcessRegistry.getProcess(name).stop();
    }

}
