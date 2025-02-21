package dev.zalaya.collector.adapter.persistence.repository;

import dev.zalaya.collector.adapter.mapper.ProcessMapper;
import dev.zalaya.collector.domain.model.Process;
import dev.zalaya.collector.domain.port.outbound.ProcessRepository;
import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.collector.infrastructure.persistence.repository.ProcessJpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProcessRepositoryAdapter implements ProcessRepository {

    private final ProcessJpaRepository repository;
    private final ProcessMapper mapper;

    public ProcessRepositoryAdapter(ProcessJpaRepository repository, ProcessMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Process> findAll() {
        List<ProcessEntity> processEntities = repository.findAll();

        return mapper.toDomain(processEntities);
    }

    @Override
    public Process findById(Long id) {
        Optional<ProcessEntity> processEntity = repository.findById(id);

        return processEntity.map(mapper::toDomain).orElse(null);
    }

    @Override
    public Process findByName(String name) {
        Optional<ProcessEntity> processEntity = repository.findByName(name);

        return processEntity.map(mapper::toDomain).orElse(null);
    }

    @Override
    public Process findByPath(String path) {
        Optional<ProcessEntity> processEntity = repository.findByPath(path);

        return processEntity.map(mapper::toDomain).orElse(null);
    }

    @Override
    public List<Process> findByMemoryLessThan(Long memory) {
        List<ProcessEntity> processEntity = repository.findByMemoryLessThan(memory);

        if (processEntity.isEmpty()) {
            return List.of();
        }

        return mapper.toDomain(processEntity);
    }

    @Override
    public List<Process> findByMemoryGreaterThan(Long memory) {
        List<ProcessEntity> processEntity = repository.findByMemoryGreaterThan(memory);

        if (processEntity.isEmpty()) {
            return List.of();
        }

        return mapper.toDomain(processEntity);
    }

    @Override
    public List<Process> findByMemoryBetween(Long minimumMemory, Long maximumMemory) {
        List<ProcessEntity> processEntity = repository.findByMemoryBetween(minimumMemory, maximumMemory);

        if (processEntity.isEmpty()) {
            return List.of();
        }

        return mapper.toDomain(processEntity);
    }

    @Override
    public Process save(Process process) {
        ProcessEntity processEntity = mapper.toEntity(process);
        ProcessEntity savedEntity = repository.save(processEntity);

        return mapper.toDomain(savedEntity);
    }

}
