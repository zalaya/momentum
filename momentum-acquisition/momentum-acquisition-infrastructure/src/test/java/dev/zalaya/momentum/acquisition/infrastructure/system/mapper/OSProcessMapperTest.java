package dev.zalaya.momentum.acquisition.infrastructure.system.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.mapper.OSProcessMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import oshi.software.os.OSProcess;

import java.util.List;

import static dev.zalaya.momentum.common.mock.OSProcessMockFactory.createOSProcessMock;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OSProcessMapperTest {

    private OSProcessMapper mapper;

    @BeforeEach
    void beforeEach() {
        mapper = Mappers.getMapper(OSProcessMapper.class);
    }

    @Test
    void givenOSProcess_whenMappingToProcess_thenReturnMappedProcess() {
        // Given
        OSProcess osProcess = createOSProcessMock(1234, "process.exe", "path/to/process", 0.5, 2048L, 5);

        // When
        Process process = mapper.toProcess(osProcess);

        // Then
        assertEquals(1234, process.getPid());
        assertEquals("process.exe", process.getName());
        assertEquals("path/to/process", process.getPath());
        assertEquals(50.0, process.getCpu());
        assertEquals(2048L, process.getMemory());
        assertEquals(5, process.getThreads());
    }

    @Test
    void givenOSProcesses_whenMappingToProcesses_thenReturnMappedProcesses() {
        // Given
        OSProcess osProcess1 = createOSProcessMock(1234, "process1.exe", "path/to/process1", 0.5, 2048L, 5);
        OSProcess osProcess2 = createOSProcessMock(4321, "process2.exe", "path/to/process2", 0.75, 2048L, 7);
        List<OSProcess> osProcesses = List.of(osProcess1, osProcess2);

        // When
        List<Process> processes = mapper.toProcesses(osProcesses);

        // Then
        assertEquals(1234, processes.get(0).getPid());
        assertEquals("process1.exe", processes.get(0).getName());
        assertEquals("path/to/process1", processes.get(0).getPath());
        assertEquals(50.0, processes.get(0).getCpu());
        assertEquals(2048L, processes.get(0).getMemory());
        assertEquals(5, processes.get(0).getThreads());

        assertEquals(4321, processes.get(1).getPid());
        assertEquals("process2.exe", processes.get(1).getName());
        assertEquals("path/to/process2", processes.get(1).getPath());
        assertEquals(75.0, processes.get(1).getCpu());
        assertEquals(2048L, processes.get(1).getMemory());
        assertEquals(7, processes.get(1).getThreads());
    }

}
