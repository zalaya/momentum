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

}
