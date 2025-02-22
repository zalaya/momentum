package dev.zalaya.collector.infrastructure.persistence.repository;

import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProcessJpaRepositoryIntegrationTest {

    @Autowired
    private ProcessJpaRepository repository;

    @Test
    void save_shouldPersistProcess() {
        // Arrange
        ProcessEntity processEntity = new ProcessEntity(null, "process", "path/to/process", 100L);

        // Act
        ProcessEntity savedProcessEntity = repository.save(processEntity);

        // Assert
        assertNotNull(savedProcessEntity.getId());
    }

    @Test
    void saveAll_shouldPersistProcesses() {
        // Arrange
        List<ProcessEntity> processEntities = List.of(new ProcessEntity(null, "process", "path/to/process", 100L));

        // Act
        List<ProcessEntity> savedProcessEntities = repository.saveAll(processEntities);

        // Assert
        assertNotNull(savedProcessEntities.get(0).getId());
    }

    @Test
    @Sql(statements = {
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (1, 'process1', 'path/to/process1', 100);",
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (2, 'process2', 'path/to/process2', 200);"
    })
    void findAll_shouldFindAllProcesses() {
        // Assure
        ProcessEntity expectedProcess1 = new ProcessEntity(1L, "process1", "path/to/process1", 100L);
        ProcessEntity expectedProcess2 = new ProcessEntity(2L, "process2", "path/to/process2", 200L);

        // Act
        List<ProcessEntity> foundProcesses = repository.findAll();

        // Assert
        assertEquals(List.of(expectedProcess1, expectedProcess2), foundProcesses);
    }

    @Test
    @Sql(statements = {
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (1, 'process', 'path/to/process', 100);"
    })
    void findById_shouldFindProcessById() {
        // Assure
        Long id = 1L;
        ProcessEntity expectedProcess = new ProcessEntity(id, "process", "path/to/process", 100L);

        // Act
        Optional<ProcessEntity> foundProcess = repository.findById(id);

        // Assert
        assertEquals(expectedProcess, foundProcess.get());
    }

    @Test
    @Sql(statements = {
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (1, 'process', 'path/to/process', 100);"
    })
    void findByName_shouldFindProcessByName() {
        // Assure
        String name = "process";
        ProcessEntity expectedProcess = new ProcessEntity(1L, name, "path/to/process", 100L);

        // Act
        Optional<ProcessEntity> foundProcess = repository.findByName(name);

        // Assert
        assertEquals(expectedProcess, foundProcess.get());
    }

    @Test
    @Sql(statements = {
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (1, 'process', 'path/to/process', 100);"
    })
    void findByPath_shouldFindProcessByPath() {
        // Assure
        String path = "path/to/process";
        ProcessEntity expectedProcess = new ProcessEntity(1L, "process", path, 100L);

        // Act
        Optional<ProcessEntity> foundProcess = repository.findByPath(path);

        // Assert
        assertEquals(expectedProcess, foundProcess.get());
    }

    @Test
    @Sql(statements = {
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (1, 'process1', 'path/to/process1', 100);",
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (2, 'process2', 'path/to/process2', 200);",
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (3, 'process3', 'path/to/process3', 300);"
    })
    void findByMemoryLessThan_shouldFindProcessesWithLessMemoryThan() {
        // Assure
        ProcessEntity expectedProcess = new ProcessEntity(1L, "process1", "path/to/process1", 100L);

        // Act
        List<ProcessEntity> foundProcess = repository.findByMemoryLessThan(200L);

        // Assert
        assertEquals(expectedProcess, foundProcess.get(0));
    }

    @Test
    @Sql(statements = {
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (1, 'process1', 'path/to/process1', 100);",
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (2, 'process2', 'path/to/process2', 200);",
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (3, 'process3', 'path/to/process3', 300);"
    })
    void findByMemoryGreaterThan_shouldFindProcessesWithGreaterMemoryThan() {
        // Assure
        ProcessEntity expectedProcess = new ProcessEntity(3L, "process3", "path/to/process3", 300L);

        // Act
        List<ProcessEntity> foundProcess = repository.findByMemoryGreaterThan(200L);

        // Assert
        assertEquals(expectedProcess, foundProcess.get(0));
    }

    @Test
    @Sql(statements = {
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (1, 'process1', 'path/to/process1', 100);",
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (2, 'process2', 'path/to/process2', 200);",
        "INSERT INTO momentum.processes (id, name, path, memory) VALUES (3, 'process3', 'path/to/process3', 300);"
    })
    void findByMemoryBetween_shouldFindProcessesWithMemoryBetween() {
        // Assure
        ProcessEntity expectedProcess = new ProcessEntity(2L, "process2", "path/to/process2", 200L);

        // Act
        List<ProcessEntity> foundProcess = repository.findByMemoryBetween(150L, 250L);

        // Assert
        assertEquals(expectedProcess, foundProcess.get(0));
    }

}
