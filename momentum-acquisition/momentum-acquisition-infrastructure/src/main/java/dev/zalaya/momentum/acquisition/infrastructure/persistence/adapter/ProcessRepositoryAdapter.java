package dev.zalaya.momentum.acquisition.infrastructure.persistence.adapter;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessRepository;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper.ProcessEntityMapper;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.repository.ProcessJpaRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProcessRepositoryAdapter implements ProcessRepository {

    private final ProcessJpaRepository repository;
    private final ProcessEntityMapper mapper;

    @Override
    public Process save(Process process) {
        ProcessEntity processEntity = mapper.toEntity(process);
        ProcessEntity savedProcessEntity = repository.save(processEntity);

        return mapper.toDomain(savedProcessEntity);
    }

}
