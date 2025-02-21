package dev.zalaya.collector.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void constructor_shouldCreateInstance() {
        // Act
        Process process = new Process("process", "path/to/process");

        // Assert
        assertInstanceOf(Process.class, process);
    }

    @Test
    void getName_shouldReturnName() {
        // Arrange
        String name = "process";
        Process process = new Process(name, "path/to/process");

        // Assert
        assertEquals(name, process.getName());
    }

    @Test
    void getPath_shouldReturnPath() {
        // Arrange
        String path = "path/to/process";
        Process process = new Process("process", path);

        // Assert
        assertEquals(path, process.getPath());
    }

    @Test
    void equals_shouldReturnTrueWhenComparingTwoEqualInstances() {
        // Arrange
        String name = "process";
        String path = "path/to/process";
        Process process1 = new Process(name, path);
        Process process2 = new Process(name, path);

        // Assert
        assertEquals(process1, process2);
    }

    @Test
    void equals_shouldReturnFalseWhenComparingTwoDifferentInstances() {
        // Arrange
        Process process1 = new Process("process1", "path/to/process1");
        Process process2 = new Process("process2", "path/to/process2");

        // Assert
        assertNotEquals(process1, process2);
    }

}
