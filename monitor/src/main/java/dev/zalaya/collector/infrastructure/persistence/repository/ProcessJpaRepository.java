package dev.zalaya.collector.infrastructure.persistence.repository;

import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcessJpaRepository extends JpaRepository<ProcessEntity, Long> {

    Optional<ProcessEntity> findByName(String name);
    Optional<ProcessEntity> findByPath(String path);
    List<ProcessEntity> findByMemoryLessThan(Long memory);
    List<ProcessEntity> findByMemoryGreaterThan(Long memory);
    List<ProcessEntity> findByMemoryBetween(Long minimumMemory, Long maximumMemory);

}
