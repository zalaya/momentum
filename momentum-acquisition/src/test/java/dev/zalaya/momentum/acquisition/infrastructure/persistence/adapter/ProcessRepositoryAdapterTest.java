package dev.zalaya.momentum.acquisition.infrastructure.persistence.adapter;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper.ProcessEntityMapper;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.repository.ProcessJpaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class ProcessRepositoryAdapterTest {

    private ProcessJpaRepository repository;
    private ProcessEntityMapper mapper;
    private ProcessRepositoryAdapter adapter;

    @BeforeEach
    void beforeEach() {
        repository = mock(ProcessJpaRepository.class);
        mapper = mock(ProcessEntityMapper.class);

        adapter = new ProcessRepositoryAdapter(repository, mapper);
    }

    @Test
    void givenProcesses_whenSaveAll_thenCallsMapperAndRepository() {
        // Given
        List<Process> processes = List.of();
        configureProcessRepositoryAdapterMocks();

        // When
        adapter.saveAll(processes);

        // Assert
        verify(mapper).toEntity(List.of());
        verify(repository).saveAll(List.of());
        verify(mapper).toDomain(List.of());
    }

    @Test
    void givenNoProcesses_whenSaveAll_thenReturnEmptyList() {
        // Given
        List<Process> processes = List.of();
        configureProcessRepositoryAdapterMocks();

        // When
        List<Process> savedProcesses = adapter.saveAll(processes);

        // Assert
        assertEquals(List.of(), savedProcesses);
    }

    private void configureProcessRepositoryAdapterMocks() {
        when(mapper.toEntity(anyList())).thenReturn(List.of());
        when(repository.saveAll(anyList())).thenReturn(List.of());
        when(mapper.toDomain(anyList())).thenReturn(List.of());
    }

    @Test
    void givenProcesses_whenSaveAll_thenReturnProcessesList() {
        // Given
        Process process1 = new Process(1, "process1.exe", "path/to/process1", 0.0, 0L, 0);
        Process process2 = new Process(2, "process2.exe", "path/to/process2", 0.0, 0L, 0);
        List<Process> processes = List.of(process1, process2);
        ProcessEntity processEntity1 = new ProcessEntity(1L, 1, "process1.exe", "path/to/process1", 0.0, 0L, 0, now());
        ProcessEntity processEntity2 = new ProcessEntity(2L, 2, "process2.exe", "path/to/process2", 0.0, 0L, 0, now());
        List<ProcessEntity> processEntities = List.of(processEntity1, processEntity2);
        configureProcessRepositoryAdapterMocks(processes, processEntities);

        // When
        List<Process> savedProcesses = adapter.saveAll(processes);

        // Assert
        assertEquals(List.of(process1, process2), savedProcesses);
    }

    private void configureProcessRepositoryAdapterMocks(List<Process> processes, List<ProcessEntity> entities) {
        when(mapper.toEntity(processes)).thenReturn(entities);
        when(repository.saveAll(entities)).thenReturn(entities);
        when(mapper.toDomain(entities)).thenReturn(processes);
    }

}
