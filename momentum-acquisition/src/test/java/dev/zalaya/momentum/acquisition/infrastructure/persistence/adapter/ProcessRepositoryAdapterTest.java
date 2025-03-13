package dev.zalaya.momentum.acquisition.infrastructure.persistence.adapter;

import dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper.ProcessEntityMapper;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.repository.ProcessJpaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        configureProcessRepositoryAdapterMocks();

        // When
        adapter.saveAll(List.of());

        // Assert
        verifySaveAllInteractions();
    }

    private void configureProcessRepositoryAdapterMocks() {
        when(mapper.toEntity(anyList())).thenReturn(List.of());
        when(repository.saveAll(anyList())).thenReturn(List.of());
        when(mapper.toDomain(anyList())).thenReturn(List.of());
    }

    private void verifySaveAllInteractions() {
        verify(mapper).toEntity(anyList());
        verify(repository).saveAll(anyList());
        verify(mapper).toDomain(anyList());
    }

}
