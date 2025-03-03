package dev.zalaya.acquisition.utilities.assertions;

import dev.zalaya.acquisition.domain.model.Process;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessAssertionFactory {

    public static void expect(Process process, Integer pid, String name, String path, Double usage, Integer threads) {
        assertEquals(pid, process.getPid(), "Process PID does not match");
        assertEquals(name, process.getName(), "Process name does not match");
        assertEquals(path, process.getPath(), "Process path does not match");
        assertEquals(usage, process.getUsage(), "Process CPU usage does not match");
        assertEquals(threads, process.getThreads(), "Process thread count does not match");
    }

}
