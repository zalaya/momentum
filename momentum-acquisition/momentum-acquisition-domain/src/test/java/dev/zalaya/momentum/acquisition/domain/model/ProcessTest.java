package dev.zalaya.momentum.acquisition.domain.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void shouldInstantiateProcessWithValidFields() {
        // Act
        Process process = new Process(1234, "process.exe", "path/to/process", 12.34, 43.21, 5);

        // Assert
        assertInstanceOf(Process.class, process);
    }

    @Test
    void shouldEnsureFieldsAreFinal() {
        // Arrange
        Field[] fields = Process.class.getDeclaredFields();

        // Assert
        for (Field field : fields) {
            assertTrue(Modifier.isFinal(field.getModifiers()));
        }
    }

    @Test
    void shouldReturnTrueWhenComparingTwoInstancesWithSameNameAndPath() {
        Process process1 = new Process(1234, "process.exe", "path/to/process", 12.34, 43.21, 5);
        Process process2 = new Process(4321, "process.exe", "path/to/process", 43.21, 12.34, 10);

        assertEquals(process1, process2);
    }

    @Test
    void shouldReturnFalseWhenComparingTwoInstancesWithDifferentNameAndPath() {
        Process process1 = new Process(1234, "process1.exe", "path/to/process1", 12.34, 43.21, 5);
        Process process2 = new Process(4321, "process2.exe", "path/to/process2", 43.21, 12.34, 10);

        assertNotEquals(process1, process2);
    }

}
