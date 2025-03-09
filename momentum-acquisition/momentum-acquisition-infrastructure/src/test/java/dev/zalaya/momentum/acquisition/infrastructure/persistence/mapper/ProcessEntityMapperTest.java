package dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessEntityMapperTest {

    private final ProcessEntityMapper mapper = Mappers.getMapper(ProcessEntityMapper.class);

    @Test
    void givenDomainProcess_whenMappedToEntity_thenFieldsAreCorrectlyTransferred() {
        // Given
        Process process = new Process(1234, "process.exe", "path/to/process", 12.34, 43.21, 5);

        // Act
        ProcessEntity processEntity = mapper.toEntity(process);

        // Then
        assertDomainMatchesEntity(process, processEntity);
    }

    private void assertDomainMatchesEntity(Process process, ProcessEntity processEntity) {
        assertEquals(process.getPid(), processEntity.getPid());
        assertEquals(process.getName(), processEntity.getName());
        assertEquals(process.getPath(), processEntity.getPath());
        assertEquals(process.getCpu(), processEntity.getCpu());
        assertEquals(process.getMemory(), processEntity.getMemory());
        assertEquals(process.getThreads(), processEntity.getThreads());
    }

    @Test
    void givenEntityProcess_whenMappedToDomain_thenFieldsAreCorrectlyTransferred() {
        // Given
        ProcessEntity processEntity = new ProcessEntity(1L, 1234, "process.exe", "path/to/process", 12.34, 43.21, 5, LocalDateTime.now());

        // Act
        Process process = mapper.toDomain(processEntity);

        // Then
        assertEntityMatchesDomain(processEntity, process);
    }

    private static void assertEntityMatchesDomain(ProcessEntity processEntity, Process process) {
        assertEquals(processEntity.getPid(), process.getPid());
        assertEquals(processEntity.getName(), process.getName());
        assertEquals(processEntity.getPath(), process.getPath());
        assertEquals(processEntity.getCpu(), process.getCpu());
        assertEquals(processEntity.getMemory(), process.getMemory());
        assertEquals(processEntity.getThreads(), process.getThreads());
    }

}
