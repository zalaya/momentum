package dev.zalaya.momentum.acquisition.application.rest.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.model.ProcessDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessDtoMapperTest {

    private ProcessDtoMapper mapper;

    @BeforeEach
    void beforeEach() {
        mapper = Mappers.getMapper(ProcessDtoMapper.class);
    }

    @Test
    void givenProcessDto_whenToDomain_thenReturnDomainProcess() {
        // Given
        ProcessDto processDto = new ProcessDto(1, "process.exe", "path/to/process", 0.0, 0, 0);

        // When
        Process process = mapper.toDomain(processDto);

        // Then
        assertProcessFields(process);
    }

    @Test
    void givenProcessDtos_whenToDomain_thenReturnDomainProcesses() {
        // Given
        ProcessDto processDto1 = new ProcessDto(1, "process.exe", "path/to/process", 0.0, 0, 0);
        ProcessDto processDto2 = new ProcessDto(1, "process.exe", "path/to/process", 0.0, 0, 0);
        List<ProcessDto> processDtos = List.of(processDto1, processDto2);

        // When
        List<Process> processes = mapper.toDomain(processDtos);

        // Then
        assertProcessFields(processes.get(0));
        assertProcessFields(processes.get(1));
    }

    private static void assertProcessFields(Process process) {
        assertAll(
            () -> assertEquals(1, process.getPid()),
            () -> assertEquals("process.exe", process.getName()),
            () -> assertEquals("path/to/process", process.getPath()),
            () -> assertEquals(0.0, process.getCpu()),
            () -> assertEquals(0L, process.getMemory()),
            () -> assertEquals(0, process.getThreads())
        );
    }

    @Test
    void givenProcess_whenToDto_thenReturnProcessDto() {
        // Given
        Process process = new Process(1, "process.exe", "path/to/process", 0.0, 0L, 0);

        // When
        ProcessDto processDto = mapper.toDto(process);

        // Then
        assertProcessDtoFields(processDto);
    }

    @Test
    void givenProcesses_whenToDto_thenReturnProcessDtos() {
        // Given
        Process process1 = new Process(1, "process.exe", "path/to/process", 0.0, 0L, 0);
        Process process2 = new Process(1, "process.exe", "path/to/process", 0.0, 0L, 0);
        List<Process> processes = List.of(process1, process2);

        // When
        List<ProcessDto> processDtos = mapper.toDto(processes);

        // Then
        assertProcessDtoFields(processDtos.get(0));
        assertProcessDtoFields(processDtos.get(1));
    }

    private static void assertProcessDtoFields(ProcessDto processDto) {
        assertAll(
            () -> assertEquals(1, processDto.getPid()),
            () -> assertEquals("process.exe", processDto.getName()),
            () -> assertEquals("path/to/process", processDto.getPath()),
            () -> assertEquals(0.0, processDto.getCpu()),
            () -> assertEquals(0, processDto.getMemory()),
            () -> assertEquals(0, processDto.getThreads())
        );
    }

}
