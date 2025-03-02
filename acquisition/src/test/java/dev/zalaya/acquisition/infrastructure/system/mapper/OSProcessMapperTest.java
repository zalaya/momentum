package dev.zalaya.acquisition.infrastructure.system.mapper;

import dev.zalaya.acquisition.domain.model.Process;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import oshi.software.os.OSProcess;

import java.util.List;

import static dev.zalaya.acquisition.infrastructure.system.mocks.OSProcessMockFactory.create;
import static dev.zalaya.acquisition.infrastructure.system.assertions.ProcessAssertionFactory.expect;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OSProcessMapperTest {

    @Autowired
    private OSProcessMapper mapper;

    @Test
    void shouldMapOSProcessToProcess() {
        // Arrange
        OSProcess osProcess = create(1, "Process", "path/to/process", 0.75, 5);

        // Act
        Process process = mapper.toProcess(osProcess);

        // Assert
        expect(process, 1, "Process", "path/to/process", 75.0, 5);
    }

    @Test
    void shouldMapOSProcessesToProcesses() {
        // Arrange
        OSProcess osProcess1 = create(1, "Process1", "path/to/process1", 0.5, 10);
        OSProcess osProcess2 = create(2, "Process2", "path/to/process2", 0.75, 5);
        List<OSProcess> osProcesses = List.of(osProcess1, osProcess2);

        // Act
        List<Process> processes = mapper.toProcesses(osProcesses);

        // Assert
        expect(processes.get(0), 1, "Process1", "path/to/process1", 50.0, 10);
        expect(processes.get(1), 2, "Process2", "path/to/process2", 75.0, 5);
    }

}
