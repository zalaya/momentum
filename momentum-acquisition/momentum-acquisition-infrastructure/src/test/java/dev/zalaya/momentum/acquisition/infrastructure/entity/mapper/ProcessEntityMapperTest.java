package dev.zalaya.momentum.acquisition.infrastructure.entity.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.mapper.ProcessEntityMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ProcessEntityMapperTest {

    private ProcessEntityMapper mapper;

    @BeforeEach
    void beforeEach() {
        mapper = Mappers.getMapper(ProcessEntityMapper.class);
    }

    @Test
    void givenProcess_whenMapping_thenReturnProcessEntity() {
        // Given
        Process process = new Process(1234, "process.exe", "path/to/process", 50.0, 2048L, 5);

        // When
        ProcessEntity processEntity = mapper.toEntity(process);

        // Then
        assertNull(processEntity.getId());
        assertEquals(1234, processEntity.getPid());
        assertEquals("process.exe", processEntity.getName());
        assertEquals("path/to/process", processEntity.getPath());
        assertEquals(50.0, processEntity.getCpu());
        assertEquals(2048L, processEntity.getMemory());
        assertEquals(5, processEntity.getThreads());
        assertNull(processEntity.getCreatedAt());
    }

    @Test
    void givenProcessEntity_whenMapping_thenReturnProcess() {
        // Given
        ProcessEntity processEntity = new ProcessEntity(1L, 1234, "process.exe", "path/to/process", 50.0, 2048L, 5, LocalDateTime.now());

        // When
        Process process = mapper.toDomain(processEntity);

        // Then
        assertEquals(1234, process.getPid());
        assertEquals("process.exe", process.getName());
        assertEquals("path/to/process", process.getPath());
        assertEquals(50.0, process.getCpu());
        assertEquals(2048L, process.getMemory());
        assertEquals(5, process.getThreads());
    }

}
