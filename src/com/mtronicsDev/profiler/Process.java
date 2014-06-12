package com.mtronicsDev.profiler;

public class Process {

    private StopWatch stopWatch;
    private String name;

    Process(String name) {

        this.name = name;

    }

    void start() {

        stopWatch = new StopWatch();
        Logger.log("Started process: " + name, name, Logger.LogLevel.INFO);

    }
    
    void stop() {

        StopWatchRegistry.removeStopWatch(stopWatch);
        float passedTime = (float)stopWatch.getPassedTime() / 1000;
        stopWatch = null;
        Logger.log("Stopped process after " + passedTime + " seconds: " + name, name, Logger.LogLevel.INFO);
        ProcessRegistry.scheduleDeletion(name);

    }

    void update() {
        if(stopWatch != null) stopWatch.update();
    }

}
