package dev.zalaya.collector.adapter.persistence.mapper;

import dev.zalaya.collector.adapter.mapper.ProcessMapper;
import dev.zalaya.collector.domain.model.Process;
import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ProcessMapperTest {

    @InjectMocks
    private ProcessMapper mapper;

    @Test
    void toDomain_shouldMapEntityToDomain() {
        // Assure
        ProcessEntity entity = new ProcessEntity(1L, "process", "path/to/process", 100L);
        Process expectedDomain = new Process("process", "path/to/process", 100L);

        // Act
        Process domain = mapper.toDomain(entity);

        // Assure
        assertEquals(expectedDomain, domain);
    }

    @Test
    void toDomain_shouldMapEntitiesToDomains() {
        // Assure
        ProcessEntity entity1 = new ProcessEntity(1L, "process1", "path/to/process1", 100L);
        ProcessEntity entity2 = new ProcessEntity(2L, "process2", "path/to/process2", 200L);
        List<ProcessEntity> entities = List.of(entity1, entity2);
        Process expectedDomain1 = new Process("process1", "path/to/process1", 100L);
        Process expectedDomain2 = new Process("process2", "path/to/process2", 200L);
        List<Process> expectedDomains = List.of(expectedDomain1, expectedDomain2);

        // Act
        List<Process> domains = mapper.toDomain(entities);

        // Assure
        assertEquals(expectedDomains, domains);
    }

    @Test
    void toEntity_shouldMapDomainToEntity() {
        // Assure
        Process domain = new Process("process", "path/to/process", 100L);
        ProcessEntity expectedEntity = new ProcessEntity(null, "process", "path/to/process", 100L);

        // Act
        ProcessEntity entity = mapper.toEntity(domain);

        // Assure
        assertEquals(expectedEntity, entity);
    }

    @Test
    void toEntity_shouldMapDomainsToEntities() {
        // Assure
        Process domain1 = new Process("process1", "path/to/process1", 100L);
        Process domain2 = new Process("process2", "path/to/process2", 200L);
        List<Process> domains = List.of(domain1, domain2);
        ProcessEntity expectedEntity1 = new ProcessEntity(null, "process1", "path/to/process1", 100L);
        ProcessEntity expectedEntity2 = new ProcessEntity(null, "process2", "path/to/process2", 200L);
        List<ProcessEntity> expectedEntities = List.of(expectedEntity1, expectedEntity2);

        // Act
        List<ProcessEntity> entities = mapper.toEntity(domains);

        // Assure
        assertEquals(expectedEntities, entities);
    }

}
