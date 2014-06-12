package com.mtronicsDev.profiler;

public class StopWatch {

    private long startTime;
    private long passedTime;

    StopWatch() {
        startTime = TimeHelper.getCurrentTime();
        StopWatchRegistry.addStopWatch(this);
    }

    void update() {
        passedTime = TimeHelper.getCurrentTime() - startTime;
    }

    long getPassedTime() {
        return passedTime;
    }
}
