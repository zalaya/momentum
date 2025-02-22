package dev.zalaya.collector.infrastructure.adapter.persistence.repository;

import dev.zalaya.collector.infrastructure.adapter.mapper.ProcessEntityMapper;
import dev.zalaya.collector.domain.model.Process;
import dev.zalaya.collector.domain.port.outbound.ProcessRepository;
import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.collector.infrastructure.persistence.repository.ProcessJpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProcessRepositoryAdapter implements ProcessRepository {

    private final ProcessJpaRepository repository;
    private final ProcessEntityMapper mapper;

    public ProcessRepositoryAdapter(ProcessJpaRepository repository, ProcessEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void saveAll(List<Process> processes) {
        List<ProcessEntity> processEntities = mapper.toEntity(processes);
        List<ProcessEntity> savedProcessEntities = repository.saveAll(processEntities);

        mapper.toDomain(savedProcessEntities);
    }

}
