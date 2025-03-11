package dev.zalaya.momentum.acquisition.infrastructure.system.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import oshi.software.os.OSProcess;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class OSProcessMapperTest {

    private OSProcessMapper mapper;

    @BeforeEach
    void beforeEach() {
        mapper = Mappers.getMapper(OSProcessMapper.class);
    }

    @Test
    void givenOSProcesses_whenToDomain_thenReturnDomainProcesses() {
        // Given
        OSProcess osProcess1 = buildOSProcess();
        OSProcess osProcess2 = buildOSProcess();

        // When
        List<Process> processes = mapper.toDomain(List.of(osProcess1, osProcess2));

        // Then
        assertProcessFields(processes.get(0));
        assertProcessFields(processes.get(1));
    }

    private static void assertProcessFields(Process process) {
        assertAll(
            () -> assertEquals(1234, process.getPid()),
            () -> assertEquals("process.exe", process.getName()),
            () -> assertEquals("path/to/process", process.getPath()),
            () -> assertEquals(50.0, process.getCpu()),
            () -> assertEquals(2048L, process.getMemory()),
            () -> assertEquals(5, process.getThreads())
        );
    }

    private OSProcess buildOSProcess() {
        OSProcess osProcess = mock(OSProcess.class);

        when(osProcess.getProcessID()).thenReturn(1234);
        when(osProcess.getName()).thenReturn("process.exe");
        when(osProcess.getPath()).thenReturn("path/to/process");
        when(osProcess.getProcessCpuLoadCumulative()).thenReturn(0.5);
        when(osProcess.getResidentSetSize()).thenReturn(2048L);
        when(osProcess.getThreadCount()).thenReturn(5);

        return osProcess;
    }

}
