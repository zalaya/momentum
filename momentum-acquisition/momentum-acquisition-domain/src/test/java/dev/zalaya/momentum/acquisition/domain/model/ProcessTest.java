package dev.zalaya.momentum.acquisition.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void givenIdenticalProcesses_whenCompared_thenTheyAreEqual() {
        // Given
        Process process1 = buildProcess("process.exe", "path/to/process");
        Process process2 = buildProcess("process.exe", "path/to/process");

        // When & Then
        assertEquals(process1, process2);
        assertEquals(process1.hashCode(), process2.hashCode());
    }

    @Test
    void givenDistinctProcesses_whenCompared_thenTheyAreNotEqual() {
        // Given
        Process process1 = buildProcess("process1.exe", "path/to/process1");
        Process process2 = buildProcess("process2.exe", "path/to/process2");

        // When & Then
        assertNotEquals(process1, process2);
        assertNotEquals(process1.hashCode(), process2.hashCode());
    }

    private static Process buildProcess(String name, String path) {
        return new Process(1234, name, path, 0.5, 2048L, 5);
    }

}
