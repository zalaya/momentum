package dev.zalaya.momentum.acquisition.infrastructure.system.adapter;

import dev.zalaya.momentum.acquisition.infrastructure.system.context.OshiContext;
import dev.zalaya.momentum.acquisition.infrastructure.system.mapper.OSProcessMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class ProcessProviderAdapterTest {

    private OshiContext context;
    private OSProcessMapper mapper;
    private ProcessProviderAdapter adapter;

    @BeforeEach
    void beforeEach() {
        context = new OshiContext();
        mapper = mock(OSProcessMapper.class);

        adapter = new ProcessProviderAdapter(context, mapper);
    }

    @Test
    void whenGetProcesses_thenCallsMapperAndOperatingSystem() {
        // Given
        configureProcessProviderAdapterMocks();

        // When
        adapter.getProcesses();

        // Then
        verifyGetProcessesInteractions();
    }

    private void configureProcessProviderAdapterMocks() {
        when(context.getOperatingSystem().getProcesses()).thenReturn(List.of());
        when(mapper.toDomain(anyList())).thenReturn(List.of());
    }

    private void verifyGetProcessesInteractions() {
        verify(context.getOperatingSystem()).getProcesses();
        verify(mapper).toDomain(anyList());
    }

}
