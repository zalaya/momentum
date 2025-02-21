package dev.zalaya.collector.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void constructor_shouldCreateInstance() {
        // Act
        Process process = new Process("process", "path/to/process", 100L);

        // Assert
        assertInstanceOf(Process.class, process);
    }

    @Test
    void getName_shouldReturnName() {
        // Arrange
        String name = "process";
        Process process = new Process(name, "path/to/process", 100L);

        // Assert
        assertEquals(name, process.getName());
    }

    @Test
    void getPath_shouldReturnPath() {
        // Arrange
        String path = "path/to/process";
        Process process = new Process("process", path, 100L);

        // Assert
        assertEquals(path, process.getPath());
    }

    @Test
    void getMemory_shouldReturnMemory() {
        // Arrange
        Long memory = 100L;
        Process process = new Process("process", "path/to/process", memory);

        // Assert
        assertEquals(memory, process.getMemory());
    }

    @Test
    void equals_shouldReturnTrueWhenComparingTwoEqualInstances() {
        // Arrange
        String name = "process";
        String path = "path/to/process";
        Long memory = 100L;
        Process process1 = new Process(name, path, memory);
        Process process2 = new Process(name, path, memory);

        // Assert
        assertEquals(process1, process2);
    }

    @Test
    void equals_shouldReturnFalseWhenComparingTwoDifferentInstances() {
        // Arrange
        Process process1 = new Process("process1", "path/to/process1", 100L);
        Process process2 = new Process("process2", "path/to/process2", 100L);

        // Assert
        assertNotEquals(process1, process2);
    }

}
