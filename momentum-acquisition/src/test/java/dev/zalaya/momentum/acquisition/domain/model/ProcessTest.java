package dev.zalaya.momentum.acquisition.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void givenProcessesWithSameNameAndPathButWithDifferentOtherAttributes_whenCompared_thenTheyAreEqual() {
        // Given
        Process process1 = new Process(1, "process.exe", "path/to/process", 0.0, 0L, 0);
        Process process2 = new Process(2, "process.exe", "path/to/process", 0.0, 0L, 0);

        // When & Then
        assertEquals(process1, process2);
        assertEquals(process1.hashCode(), process2.hashCode());
    }

    @Test
    void givenProcessesWithDifferentNameAndPathButSameOtherAttributes_whenCompared_thenTheyAreNotEqual() {
        // Given
        Process process1 = new Process(1, "process1.exe", "path/to/process1", 0.0, 0L, 0);
        Process process2 = new Process(2, "process2.exe", "path/to/process2", 0.0, 0L, 0);

        // When & Then
        assertNotEquals(process1, process2);
        assertNotEquals(process1.hashCode(), process2.hashCode());
    }

}
