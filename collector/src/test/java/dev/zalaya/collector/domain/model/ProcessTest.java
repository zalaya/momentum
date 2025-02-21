package dev.zalaya.collector.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessTest {

    @Test
    void shouldReturnNameWhenCallingGetName() {
        // Arrange
        String name = "process";
        String path = "path/to/process";
        Process process = new Process(name, path);

        // Assert
        assertEquals(name, process.getName());
    }

}
