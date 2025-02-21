package dev.zalaya.collector.infrastructure.repository;

import dev.zalaya.collector.infrastructure.entity.ProcessEntity;

import jakarta.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
class ProcessJpaRepositoryTest {

    @Autowired
    private ProcessJpaRepository repository;

    @Test
    void save_shouldPersistProcess() {
        // Assert
        ProcessEntity entity = new ProcessEntity(null, "process", "path/to/process", 100L);

        // Act
        ProcessEntity savedEntity = repository.save(entity);

        // Assert
        assertNotNull(savedEntity.getId());
    }

}
