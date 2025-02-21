package dev.zalaya.collector.infrastructure.repository;

import dev.zalaya.collector.infrastructure.entity.ProcessEntity;

import jakarta.transaction.Transactional;

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
@Transactional
class ProcessJpaRepositoryTest {

    @Autowired
    private ProcessJpaRepository repository;

    @Test
    void save_shouldPersistProcess() {
        // Arrange
        ProcessEntity process = new ProcessEntity(null, "process", "path/to/process", 100L);

        // Act
        ProcessEntity savedProcess = repository.save(process);

        // Assert
        assertNotNull(savedProcess.getId());
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

}
