package dev.zalaya.collector.infrastructure.persistence.repository;

import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessJpaRepository extends JpaRepository<ProcessEntity, Long> {

}
