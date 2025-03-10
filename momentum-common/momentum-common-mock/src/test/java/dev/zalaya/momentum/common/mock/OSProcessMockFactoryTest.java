package dev.zalaya.momentum.common.mock;

import org.junit.jupiter.api.Test;
import oshi.software.os.OSProcess;

import static dev.zalaya.momentum.common.mock.OSProcessMockFactory.createOSProcessMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OSProcessMockFactoryTest {

    @Test
    void givenParameters_whenCreateOSProcessMock_thenReturnMockWithExpectedValues() {
        // When
        OSProcess osProcess = createOSProcessMock(1234, "process.exe", "path/to/process", 0.5, 2048L, 5);

        // Then
        assertEquals(1234, osProcess.getProcessID());
        assertEquals("process.exe", osProcess.getName());
        assertEquals("path/to/process", osProcess.getPath());
        assertEquals(0.5, osProcess.getProcessCpuLoadCumulative());
        assertEquals(2048L, osProcess.getResidentSetSize());
        assertEquals(5, osProcess.getThreadCount());
    }

}
