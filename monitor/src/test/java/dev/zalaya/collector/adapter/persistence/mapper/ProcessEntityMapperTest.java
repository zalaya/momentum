package dev.zalaya.collector.adapter.persistence.mapper;

import dev.zalaya.collector.adapter.mapper.ProcessEntityMapper;
import dev.zalaya.collector.domain.model.Process;
import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ProcessEntityMapperTest {

    @InjectMocks
    private ProcessEntityMapper mapper;

    @Test
    void toDomain_shouldMapProcessEntityToProcess() {
        // Assure
        ProcessEntity processEntity = new ProcessEntity(1L, "process", "path/to/process", 100L);
        Process expectedProcesses = new Process("process", "path/to/process", 100L);

        // Act
        Process process = mapper.toDomain(processEntity);

        // Assure
        assertEquals(expectedProcesses, process);
    }

    @Test
    void toDomain_shouldMapProcessEntitiesToProcesses() {
        // Assure
        ProcessEntity processEntity = new ProcessEntity(1L, "process1", "path/to/process1", 100L);
        List<ProcessEntity> processEntities = List.of(processEntity);
        Process process = new Process("process1", "path/to/process1", 100L);
        List<Process> expectedProcesses = List.of(process);

        // Act
        List<Process> processes = mapper.toDomain(processEntities);

        // Assure
        assertEquals(expectedProcesses, processes);
    }

    @Test
    void toEntity_shouldMapProcessToProcessEntity() {
        // Assure
        Process process = new Process("process", "path/to/process", 100L);
        ProcessEntity expectedProcessEntity = new ProcessEntity(null, "process", "path/to/process", 100L);

        // Act
        ProcessEntity processEntity = mapper.toEntity(process);

        // Assure
        assertEquals(expectedProcessEntity, processEntity);
    }

    @Test
    void toEntity_shouldMapProcessesToProcessEntities() {
        // Assure
        Process process = new Process("process1", "path/to/process1", 100L);
        List<Process> processes = List.of(process);
        ProcessEntity processEntity = new ProcessEntity(null, "process1", "path/to/process1", 100L);
        List<ProcessEntity> expectedProcessEntities = List.of(processEntity);

        // Act
        List<ProcessEntity> processEntities = mapper.toEntity(processes);

        // Assure
        assertEquals(expectedProcessEntities, processEntities);
    }

}
