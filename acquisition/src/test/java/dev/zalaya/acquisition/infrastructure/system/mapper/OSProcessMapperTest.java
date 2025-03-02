package dev.zalaya.acquisition.infrastructure.system.mapper;

import dev.zalaya.acquisition.domain.model.Process;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import oshi.software.os.OSProcess;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OSProcessMapperTest {

    @Autowired
    private OSProcessMapper mapper;

    @Test
    void shouldMapOSProcessToProcess() {
        // Arrange
        OSProcess osProcess = createOSProcessMock(1, "Process", "path/to/process", 0.75, 5);

        // Act
        Process process = mapper.toProcess(osProcess);

        // Assert
        assertProcess(process, 1, "Process", "path/to/process", 75.0, 5);
    }

    @Test
    void shouldMapOSProcessesToProcesses() {
        // Arrange
        OSProcess osProcess1 = createOSProcessMock(1, "Process1", "path/to/process1", 0.5, 10);
        OSProcess osProcess2 = createOSProcessMock(2, "Process2", "path/to/process2", 0.75, 5);
        List<OSProcess> osProcesses = List.of(osProcess1, osProcess2);

        // Act
        List<Process> processes = mapper.toProcesses(osProcesses);

        // Assert
        assertProcess(processes.get(0), 1, "Process1", "path/to/process1", 50.0, 10);
        assertProcess(processes.get(1), 2, "Process2", "path/to/process2", 75.0, 5);
    }

    private OSProcess createOSProcessMock(Integer pid, String name, String path, Double usage, Integer threads) {
        OSProcess osProcessMock = mock(OSProcess.class);

        when(osProcessMock.getProcessID()).thenReturn(pid);
        when(osProcessMock.getName()).thenReturn(name);
        when(osProcessMock.getPath()).thenReturn(path);
        when(osProcessMock.getProcessCpuLoadCumulative()).thenReturn(usage);
        when(osProcessMock.getThreadCount()).thenReturn(threads);

        return osProcessMock;
    }

    private void assertProcess(Process process, Integer pid, String name, String path, Double usage, Integer threads) {
        assertEquals(pid, process.getPid());
        assertEquals(name, process.getName());
        assertEquals(path, process.getPath());
        assertEquals(usage, process.getUsage());
        assertEquals(threads, process.getThreads());
    }

}
