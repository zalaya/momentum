package dev.zalaya.collector.infrastructure.repository;

import dev.zalaya.collector.infrastructure.entity.ProcessEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessJpaRepository extends JpaRepository<ProcessEntity, Long> {

}
