package dev.zalaya.momentum.acquisition.application.rest.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.model.ProcessDto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProcessDtoMapper {

    Process toDomain(ProcessDto processDto);
    List<Process> toDomain(List<ProcessDto> processDto);

    ProcessDto toDto(Process process);
    List<ProcessDto> toDto(List<Process> processes);

}
