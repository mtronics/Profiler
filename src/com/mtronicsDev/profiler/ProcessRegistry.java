package com.mtronicsDev.profiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessRegistry {

    private static Map<String, Process> processes = new HashMap<String, Process>();
    private static List<String> scheduledDeletions = new ArrayList<String>();
    private static Map<String, Process> scheduledAdditions = new HashMap<String, Process>();

    static void addProcess(String name, Process process) {
        scheduledAdditions.put(name, process);
    }

    static Process getProcess(String name) {
        return processes.get(name);
    }

    static void updateAll() {

        for (String processName : scheduledDeletions) {
            processes.remove(processName);
        }

        processes.putAll(scheduledAdditions);

        for (Process process : processes.values()) {
            process.update();
        }

    }

    static void scheduleDeletion(String processName) {
        scheduledDeletions.add(processName);
    }

}
