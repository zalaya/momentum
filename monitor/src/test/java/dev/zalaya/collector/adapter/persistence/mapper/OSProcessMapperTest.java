package dev.zalaya.collector.adapter.persistence.mapper;

import dev.zalaya.collector.adapter.mapper.OSProcessMapper;

import dev.zalaya.collector.domain.model.Process;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import oshi.software.os.OSProcess;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OSProcessMapperTest {

    @InjectMocks
    private OSProcessMapper mapper;

    @Test
    void toDomain_shouldMapOSProcessToProcess() {
        // Assure
        OSProcess osProcess = mock(OSProcess.class);
        Process expectedProcess = new Process("process", "path/to/process", 100L);

        // Mock
        when(osProcess.getName()).thenReturn("process");
        when(osProcess.getPath()).thenReturn("path/to/process");
        when(osProcess.getResidentSetSize()).thenReturn(100L);

        // Act
        Process process = mapper.toDomain(osProcess);

        // Assert
        assertEquals(expectedProcess, process);
    }

    @Test
    void toDomain_shouldMapOSProcessesToProcesses() {
        // Assure
        OSProcess osProcess = mock(OSProcess.class);
        List<OSProcess> osProcesses = List.of(osProcess);
        Process expectedProcess = new Process("process", "path/to/process", 100L);
        List<Process> expectedProcesses = List.of(expectedProcess);

        // Mock
        when(osProcess.getName()).thenReturn("process");
        when(osProcess.getPath()).thenReturn("path/to/process");
        when(osProcess.getResidentSetSize()).thenReturn(100L);

        // Act
        List<Process> processes = mapper.toDomain(osProcesses);

        // Assert
        assertEquals(expectedProcesses, processes);
    }

}
