package dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;

import org.mapstruct.Mapper;

@Mapper
public interface ProcessEntityMapper {

    ProcessEntity toEntity(Process process);
    Process toDomain(ProcessEntity processEntity);

}
