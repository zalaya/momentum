package dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ProcessEntityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ProcessEntity toEntity(Process process);

    Process toDomain(ProcessEntity processEntity);

}
