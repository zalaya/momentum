package dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.entity.ProcessEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProcessEntityMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    ProcessEntity toEntity(Process process);
    List<ProcessEntity> toEntity(List<Process> processes);

    Process toDomain(ProcessEntity processEntity);
    List<Process> toDomain(List<ProcessEntity> processEntities);

}
