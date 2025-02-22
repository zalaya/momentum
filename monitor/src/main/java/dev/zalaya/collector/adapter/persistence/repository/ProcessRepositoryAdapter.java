package dev.zalaya.collector.adapter.persistence.repository;

import dev.zalaya.collector.adapter.mapper.ProcessEntityMapper;
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
    private final ProcessEntityMapper mapper;

    public ProcessRepositoryAdapter(ProcessJpaRepository repository, ProcessEntityMapper mapper) {
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
    public Process save(Process process) {
        ProcessEntity processEntity = mapper.toEntity(process);
        ProcessEntity savedProcessEntity = repository.save(processEntity);

        return mapper.toDomain(savedProcessEntity);
    }

    @Override
    public List<Process> saveAll(List<Process> processes) {
        List<ProcessEntity> processEntities = mapper.toEntity(processes);
        List<ProcessEntity> savedProcessEntities = repository.saveAll(processEntities);

        return mapper.toDomain(savedProcessEntities);
    }

}
