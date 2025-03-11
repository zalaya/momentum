package dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.mapper;

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
        ProcessEntity processEntity1 = buildProcessEntity("process1.exe", "path/to/process1");
        ProcessEntity processEntity2 = buildProcessEntity("process2.exe", "path/to/process2");

        // When
        List<Process> processes = mapper.toDomain(List.of(processEntity1, processEntity2));

        // Then
        assertProcessFields(processes.get(0), "process1.exe", "path/to/process1");
        assertProcessFields(processes.get(1), "process2.exe", "path/to/process2");
    }

    private static void assertProcessFields(Process process, String name, String path) {
        assertAll(
            () -> assertEquals(1234, process.getPid()),
            () -> assertEquals(name, process.getName()),
            () -> assertEquals(path, process.getPath()),
            () -> assertEquals(50.0, process.getCpu()),
            () -> assertEquals(2048L, process.getMemory()),
            () -> assertEquals(5, process.getThreads())
        );
    }


    private static ProcessEntity buildProcessEntity(String name, String path) {
        return new ProcessEntity(1L, 1234, name, path, 50.0, 2048L, 5, LocalDateTime.now());
    }

}
