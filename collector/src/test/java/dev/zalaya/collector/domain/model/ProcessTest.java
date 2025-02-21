package dev.zalaya.collector.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void constructor_shouldCreateInstance() {
        // Arrange
        String name = "process";
        String path = "path/to/process";

        // Act
        Process process = new Process(name, path);

        // Assert
        assertInstanceOf(Process.class, process);
    }

    @Test
    void getName_shouldReturnName() {
        // Arrange
        String name = "process";
        String path = "path/to/process";
        Process process = new Process(name, path);

        // Assert
        assertEquals(name, process.getName());
    }

    @Test
    void getPath_shouldReturnPath() {
        // Arrange
        String name = "process";
        String path = "path/to/process";
        Process process = new Process(name, path);

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
        String name1 = "process1";
        String path1 = "path/to/process1";
        String name2 = "process2";
        String path2 = "path/to/process2";
        Process process1 = new Process(name1, path1);
        Process process2 = new Process(name2, path2);

        // Assert
        assertNotEquals(process1, process2);
    }

}
