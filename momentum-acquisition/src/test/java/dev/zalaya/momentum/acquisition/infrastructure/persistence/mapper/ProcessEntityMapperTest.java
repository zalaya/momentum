package dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.List;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;

class ProcessEntityMapperTest {

    private ProcessEntityMapper mapper;

    @BeforeEach
    void beforeEach() {
        mapper = Mappers.getMapper(ProcessEntityMapper.class);
    }

    @Test
    void givenProcessEntity_whenToDomain_thenReturnDomainProcess() {
        // Given
        ProcessEntity processEntity = new ProcessEntity(1L, 1, "process.exe", "path/to/process", 0.0, 0L, 0, now());

        // When
        Process process = mapper.toDomain(processEntity);

        // Then
        assertProcessFields(process);
    }

    @Test
    void givenProcessEntities_whenToDomain_thenReturnDomainProcesses() {
        // Given
        ProcessEntity processEntity1 = new ProcessEntity(1L, 1, "process.exe", "path/to/process", 0.0, 0L, 0, now());
        ProcessEntity processEntity2 = new ProcessEntity(1L, 1, "process.exe", "path/to/process", 0.0, 0L, 0, now());
        List<ProcessEntity> processEntities = List.of(processEntity1, processEntity2);

        // When
        List<Process> processes = mapper.toDomain(processEntities);

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
    void givenProcess_whenToEntity_thenReturnEntityProcess() {
        // Given
        Process process = new Process(1, "process.exe", "path/to/process", 0.0, 0L, 0);

        // When
        ProcessEntity processEntity = mapper.toEntity(process);

        // Then
        assertProcessEntityFields(processEntity);
    }

    @Test
    void givenProcesses_whenToEntity_thenReturnEntityProcesses() {
        // Given
        Process process1 = new Process(1, "process.exe", "path/to/process", 0.0, 0L, 0);
        Process process2 = new Process(1, "process.exe", "path/to/process", 0.0, 0L, 0);
        List<Process> processes = List.of(process1, process2);

        // When
        List<ProcessEntity> processEntities = mapper.toEntity(processes);

        // Then
        assertProcessEntityFields(processEntities.get(0));
        assertProcessEntityFields(processEntities.get(1));
    }

    private static void assertProcessEntityFields(ProcessEntity processEntity) {
        assertAll(
            () -> assertNull(processEntity.getId()),
            () -> assertEquals(1, processEntity.getPid()),
            () -> assertEquals("process.exe", processEntity.getName()),
            () -> assertEquals("path/to/process", processEntity.getPath()),
            () -> assertEquals(0.0, processEntity.getCpu()),
            () -> assertEquals(0L, processEntity.getMemory()),
            () -> assertEquals(0, processEntity.getThreads()),
            () -> assertNull(processEntity.getCreatedAt())
        );
    }

}
