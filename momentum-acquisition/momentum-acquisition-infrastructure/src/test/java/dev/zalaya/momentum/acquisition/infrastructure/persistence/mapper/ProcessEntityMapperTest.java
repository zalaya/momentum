package dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessEntityMapperTest {

    private ProcessEntityMapper mapper;

    @BeforeEach
    void beforeEach() {
        mapper = Mappers.getMapper(ProcessEntityMapper.class);
    }

    @Test
    void givenProcessEntities_whenToDomain_thenReturnDomainProcesses() {
        // Given
        ProcessEntity processEntity1 = buildProcessEntity();
        ProcessEntity processEntity2 = buildProcessEntity();

        // When
        List<Process> processes = mapper.toDomain(List.of(processEntity1, processEntity2));

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


    private static ProcessEntity buildProcessEntity() {
        return new ProcessEntity(1L, 1234, "process.exe", "path/to/process", 50.0, 2048L, 5, LocalDateTime.now());
    }

}
