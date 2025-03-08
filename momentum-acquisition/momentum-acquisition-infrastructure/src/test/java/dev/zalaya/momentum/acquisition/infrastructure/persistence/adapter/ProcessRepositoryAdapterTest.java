package dev.zalaya.momentum.acquisition.infrastructure.persistence.adapter;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper.ProcessEntityMapper;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.repository.ProcessJpaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void givenProcess_whenSave_thenMapperAndRepositoryAreInvoked() {
        // Given
        Process process = new Process(1234, "process.exe", "path/to/process", 12.34, 43.21, 5);
        ProcessEntity processEntity = new ProcessEntity(1L, 1234, "process.exe", "path/to/process", 12.34, 43.21, 5, LocalDateTime.now());

        setUpMethodInvocations(process, processEntity);

        // When
        Process savedProcess = adapter.save(process);

        // Assert
        verify(mapper).toEntity(process);
        verify(repository).save(processEntity);
        verify(mapper).toDomain(processEntity);
        assertEquals(process, savedProcess);
    }

    private void setUpMethodInvocations(Process process, ProcessEntity processEntity) {
        when(mapper.toEntity(process)).thenReturn(processEntity);
        when(repository.save(processEntity)).thenReturn(processEntity);
        when(mapper.toDomain(processEntity)).thenReturn(process);
    }
    
}
