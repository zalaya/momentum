package dev.zalaya.momentum.acquisition.domain.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @Test
    void givenProcessClass_whenCheckingModifiers_thenClassIsFinal() {
        // Given
        int modifiers = Process.class.getModifiers();

        // When & Then
        assertTrue(Modifier.isFinal(modifiers));
    }

    @Test
    void givenProcessMethods_whenCheckingPublicMethods_thenNoPublicSettersExist() {
        // Given
        Method[] methods = Process.class.getMethods();

        // When & Then
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                fail();
            }
        }
    }

    @Test
    void givenProcessFields_whenCheckingModifiers_thenFieldsArePrivate() {
        // Given
        Field[] fields = Process.class.getDeclaredFields();

        // When & Then
        for (Field field : fields) {
            if (!Modifier.isPrivate(field.getModifiers())) {
                fail();
            }
        }
    }

    @Test
    void givenProcessFields_whenCheckingModifiers_thenFieldsAreFinal() {
        // Given
        Field[] fields = Process.class.getDeclaredFields();

        // When & Then
        for (Field field : fields) {
            if (!Modifier.isFinal(field.getModifiers())) {
                fail();
            }
        }
    }

    @Test
    void givenIdenticalProcesses_whenCompared_thenTheyAreEqual() {
        // Given
        Process process1 = new Process(1234, "process.exe", "path/to/process", 12.34, 43.21, 5);
        Process process2 = new Process(1234, "process.exe", "path/to/process", 12.34, 43.21, 5);

        // When & Then
        assertEquals(process1, process2);
        assertEquals(process1.hashCode(), process2.hashCode());
    }

    @Test
    void givenDifferentProcesses_whenCompared_thenTheyAreNotEqual() {
        // Given
        Process process1 = new Process(1234, "process1.exe", "path/to/process1", 12.34, 43.21, 5);
        Process process2 = new Process(4321, "process2.exe", "path/to/process2", 43.21, 12.34, 10);

        // When & Then
        assertNotEquals(process1, process2);
        assertNotEquals(process1.hashCode(), process2.hashCode());
    }

}
