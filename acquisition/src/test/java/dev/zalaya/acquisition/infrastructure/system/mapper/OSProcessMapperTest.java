package dev.zalaya.acquisition.infrastructure.system.mapper;

import dev.zalaya.acquisition.domain.model.Process;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import oshi.software.os.OSProcess;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Import(OSProcessMapperImpl.class)
@ExtendWith({SpringExtension.class, MockitoExtension.class})
class OSProcessMapperTest {

    @Autowired
    private OSProcessMapper mapper;

    @Mock
    private OSProcess osProcess;

    @Test
    void shouldMapOSProcessToProcess() {
        // Arrange
        when(osProcess.getProcessID()).thenReturn(1);
        when(osProcess.getName()).thenReturn("Process");
        when(osProcess.getPath()).thenReturn("path/to/process");
        when(osProcess.getProcessCpuLoadCumulative()).thenReturn(0.75);
        when(osProcess.getThreadCount()).thenReturn(5);

        // Act
        Process process = mapper.toProcess(osProcess);

        // Assert
        assertEquals(1, process.getPid());
        assertEquals("Process", process.getName());
        assertEquals("path/to/process", process.getPath());
        assertEquals(75.0, process.getUsage());
        assertEquals(5, process.getThreads());
    }

}
