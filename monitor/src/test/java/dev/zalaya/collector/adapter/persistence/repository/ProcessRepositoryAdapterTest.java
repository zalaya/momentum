package dev.zalaya.collector.adapter.persistence.repository;

import dev.zalaya.collector.adapter.mapper.ProcessMapper;
import dev.zalaya.collector.domain.model.Process;
import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.collector.infrastructure.persistence.repository.ProcessJpaRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProcessRepositoryAdapterTest {

    @Mock
    private ProcessJpaRepository repository;

    @Mock
    private ProcessMapper mapper;

    @InjectMocks
    private ProcessRepositoryAdapter adapter;

    @Test
    void findAll_shouldFindAllProcesses() {
        // Assure
        ProcessEntity processEntity1 = new ProcessEntity(1L, "process1", "path/to/process1", 100L);
        ProcessEntity processEntity2 = new ProcessEntity(2L, "process2", "path/to/process2", 200L);
        List<ProcessEntity> processEntities = List.of(processEntity1, processEntity2);
        Process expectedProcess1 = new Process("process1", "path/to/process1", 100L);
        Process expectedProcess2 = new Process("process2", "path/to/process2", 200L);
        List<Process> expectedProcesses = List.of(expectedProcess1, expectedProcess2);

        // Mock
        when(repository.findAll()).thenReturn(processEntities);
        when(mapper.toDomain(processEntities)).thenReturn(expectedProcesses);

        // Act
        List<Process> foundProcesses = adapter.findAll();

        // Assert
        verify(repository).findAll();
        assertEquals(expectedProcesses, foundProcesses);
    }

    @Test
    void findById_shouldFindProcessById() {
        // Assure
        Long id = 100L;
        ProcessEntity processEntity = new ProcessEntity(1L, "process", "path/to/process", id);
        Optional<ProcessEntity> optionalProcessEntity = Optional.of(processEntity);
        Process expectedProcess = new Process("process", "path/to/process", id);

        // Mock
        when(repository.findById(id)).thenReturn(optionalProcessEntity);
        when(mapper.toDomain(processEntity)).thenReturn(expectedProcess);

        // Act
        Process foundProcess = adapter.findById(id);

        // Assert
        verify(repository).findById(id);
        assertEquals(expectedProcess, foundProcess);
    }

    @Test
    void findByName_shouldFindProcessByName() {
        // Assure
        String name = "process";
        ProcessEntity processEntity = new ProcessEntity(1L, name, "path/to/process", 100L);
        Optional<ProcessEntity> optionalProcessEntity = Optional.of(processEntity);
        Process expectedProcess = new Process(name, "path/to/process", 100L);

        // Mock
        when(repository.findByName(name)).thenReturn(optionalProcessEntity);
        when(mapper.toDomain(processEntity)).thenReturn(expectedProcess);

        // Act
        Process foundProcess = adapter.findByName(name);

        // Assert
        verify(repository).findByName(name);
        assertEquals(expectedProcess, foundProcess);
    }

    @Test
    void findByPath_shouldFindProcessByPath() {
        // Assure
        String path = "path/to/process";
        ProcessEntity processEntity = new ProcessEntity(1L, "process", path, 100L);
        Optional<ProcessEntity> optionalProcessEntity = Optional.of(processEntity);
        Process expectedProcess = new Process("process", path, 100L);

        // Mock
        when(repository.findByPath(path)).thenReturn(optionalProcessEntity);
        when(mapper.toDomain(processEntity)).thenReturn(expectedProcess);

        // Act
        Process foundProcess = adapter.findByPath(path);

        // Assert
        verify(repository).findByPath(path);
        assertEquals(expectedProcess, foundProcess);
    }

    @Test
    void findByMemoryLessThan_shouldFindProcessesWithLessMemoryThan() {
        // Assure
        ProcessEntity processEntity1 = new ProcessEntity(1L, "process1", "path/to/process1", 100L);
        ProcessEntity processEntity2 = new ProcessEntity(2L, "process2", "path/to/process2", 200L);
        ProcessEntity processEntity3 = new ProcessEntity(3L, "process3", "path/to/process3", 300L);
        List<ProcessEntity> processEntities = List.of(processEntity1, processEntity2, processEntity3);
        Process expectedProcess = new Process("process1", "path/to/process1", 100L);
        List<Process> expectedProcesses = List.of(expectedProcess);

        // Mock
        when(repository.findByMemoryLessThan(200L)).thenReturn(processEntities);
        when(mapper.toDomain(processEntities)).thenReturn(expectedProcesses);

        // Act
        List<Process> foundProcesses = adapter.findByMemoryLessThan(200L);

        // Assert
        verify(repository).findByMemoryLessThan(200L);
        assertEquals(expectedProcesses, foundProcesses);
    }

    @Test
    void findByMemoryGreaterThan_shouldFindProcessesWithGreaterMemoryThan() {
        // Assure
        ProcessEntity processEntity1 = new ProcessEntity(1L, "process1", "path/to/process1", 100L);
        ProcessEntity processEntity2 = new ProcessEntity(2L, "process2", "path/to/process2", 200L);
        ProcessEntity processEntity3 = new ProcessEntity(3L, "process3", "path/to/process3", 300L);
        List<ProcessEntity> processEntities = List.of(processEntity1, processEntity2, processEntity3);
        Process expectedProcess = new Process("process3", "path/to/process3", 300L);
        List<Process> expectedProcesses = List.of(expectedProcess);

        // Mock
        when(repository.findByMemoryGreaterThan(200L)).thenReturn(processEntities);
        when(mapper.toDomain(processEntities)).thenReturn(expectedProcesses);

        // Act
        List<Process> foundProcesses = adapter.findByMemoryGreaterThan(200L);

        // Assert
        verify(repository).findByMemoryGreaterThan(200L);
        assertEquals(expectedProcesses, foundProcesses);
    }

    @Test
    void findByMemoryBetween_shouldFindProcessesWithMemoryBetween() {
        // Assure
        ProcessEntity processEntity1 = new ProcessEntity(1L, "process1", "path/to/process1", 100L);
        ProcessEntity processEntity2 = new ProcessEntity(2L, "process2", "path/to/process2", 200L);
        ProcessEntity processEntity3 = new ProcessEntity(3L, "process3", "path/to/process3", 300L);
        List<ProcessEntity> processEntities = List.of(processEntity1, processEntity2, processEntity3);
        Process expectedProcess = new Process("process2", "path/to/process2", 200L);
        List<Process> expectedProcesses = List.of(expectedProcess);

        // Mock
        when(repository.findByMemoryBetween(150L, 250L)).thenReturn(processEntities);
        when(mapper.toDomain(processEntities)).thenReturn(expectedProcesses);

        // Act
        List<Process> foundProcesses = adapter.findByMemoryBetween(150L, 250L);

        // Assert
        verify(repository).findByMemoryBetween(150L, 250L);
        assertEquals(expectedProcesses, foundProcesses);
    }

}
