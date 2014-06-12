package com.mtronicsDev.profiler;

import java.util.ArrayList;
import java.util.List;

public class StopWatchRegistry {

    static List<StopWatch> stopWatches = new ArrayList<StopWatch>();

    static void addStopWatch(StopWatch stopWatch) {
        stopWatches.add(stopWatch);
    }

    static void removeStopWatch(StopWatch stopWatch) {
        stopWatches.remove(stopWatch);
    }

}
