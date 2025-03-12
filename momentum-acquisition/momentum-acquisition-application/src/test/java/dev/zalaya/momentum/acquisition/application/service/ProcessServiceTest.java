package dev.zalaya.momentum.acquisition.application.service;

import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessProvider;
import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ProcessServiceTest {

    private ProcessProvider provider;
    private ProcessRepository repository;
    private ProcessService service;

    @BeforeEach
    void beforeEach() {
        provider = mock(ProcessProvider.class);
        repository = mock(ProcessRepository.class);

        service = new ProcessService(provider, repository);
    }

    @Test
    void whenGetProcesses_thenCallsProviderAndRepository() {
        // Given
        configureProcessServiceMocks();

        // When
        service.getProcesses();

        // Assert
        verifyGetProcessesInteractions();
    }

    private void configureProcessServiceMocks() {
        when(provider.getProcesses()).thenReturn(List.of());
        when(repository.saveAll(anyList())).thenReturn(List.of());
    }

    private void verifyGetProcessesInteractions() {
        verify(provider).getProcesses();
        verify(repository).saveAll(anyList());
    }

}
