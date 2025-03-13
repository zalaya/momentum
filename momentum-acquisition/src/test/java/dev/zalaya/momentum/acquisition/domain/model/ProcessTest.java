package dev.zalaya.momentum.acquisition.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void givenProcessesWithSameNameAndPathButWithDifferentOtherAttributes_whenCompared_thenTheyAreEqual() {
        // Given
        Process process1 = buildProcess(1234, "process.exe", "path/to/process", 0.5, 2048L, 5);
        Process process2 = buildProcess(5678, "process.exe", "path/to/process", 1.0, 4096L, 10);

        // When & Then
        assertEquals(process1, process2);
        assertEquals(process1.hashCode(), process2.hashCode());
    }

    @Test
    void givenProcessesWithDifferentNameAndPathButSameOtherAttributes_whenCompared_thenTheyAreNotEqual() {
        // Given
        Process process1 = buildProcess(1234, "process1.exe", "path/to/process1", 0.5, 2048L, 5);
        Process process2 = buildProcess(1234, "process2.exe", "path/to/process2", 0.5, 2048L, 5);

        // When & Then
        assertNotEquals(process1, process2);
        assertNotEquals(process1.hashCode(), process2.hashCode());
    }

    private static Process buildProcess(int pid, String name, String path, double cpu, long memory, int threads) {
        return new Process(pid, name, path, cpu, memory, threads);
    }

}
