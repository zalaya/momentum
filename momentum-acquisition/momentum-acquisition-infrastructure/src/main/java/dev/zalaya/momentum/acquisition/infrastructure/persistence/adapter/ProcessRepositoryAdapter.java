package dev.zalaya.momentum.acquisition.infrastructure.persistence.adapter;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessRepository;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.mapper.ProcessEntityMapper;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.repository.ProcessJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProcessRepositoryAdapter implements ProcessRepository {

    private final ProcessJpaRepository repository;
    private final ProcessEntityMapper mapper;

    @Override
    public List<Process> saveAll(List<Process> processes) {
        List<ProcessEntity> mappedProcessEntities = mapper.toEntity(processes);
        List<ProcessEntity> savedProcessesEntities = repository.saveAll(mappedProcessEntities);

        return mapper.toDomain(savedProcessesEntities);
    }

}
