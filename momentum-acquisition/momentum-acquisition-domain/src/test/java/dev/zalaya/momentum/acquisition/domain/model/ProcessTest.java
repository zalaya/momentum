package dev.zalaya.momentum.acquisition.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void givenTwoInstancesWithEqualNamesOrPaths_whenComparing_thenReturnTrue() {
        // Arrange
        Process process1 = new Process(1234, "process.exe", "path/to/process", 12.34, 43.21, 5);
        Process process2 = new Process(4321, "process.exe", "path/to/process", 43.21, 12.34, 10);

        // Act & Assert
        assertEquals(process1, process2);
    }

    @Test
    void givenTwoInstancesWithDifferentNamesOrPaths_whenComparing_thenReturnFalse() {
        // Arrange
        Process process1 = new Process(1234, "process1.exe", "path/to/process1", 12.34, 43.21, 5);
        Process process2 = new Process(4321, "process2.exe", "path/to/process2", 43.21, 12.34, 10);

        // Act & Assert
        assertNotEquals(process1, process2);
    }

}
