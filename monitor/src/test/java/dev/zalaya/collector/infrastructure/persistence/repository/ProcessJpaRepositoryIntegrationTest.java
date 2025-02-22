package dev.zalaya.collector.infrastructure.persistence.repository;

import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProcessJpaRepositoryIntegrationTest {

    @Autowired
    private ProcessJpaRepository repository;

    @Test
    void saveAll_shouldPersistProcesses() {
        // Arrange
        List<ProcessEntity> processEntities = List.of(new ProcessEntity(null, "process", "path/to/process", 100L));

        // Act
        List<ProcessEntity> savedProcessEntities = repository.saveAll(processEntities);

        // Assert
        assertNotNull(savedProcessEntities.get(0).getId());
    }

}
