package dev.zalaya.momentum.acquisition.infrastructure.system.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import oshi.software.os.OSProcess;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OSProcessMapper {

    @Mapping(target = "pid", source = "processID")
    @Mapping(target = "cpu", expression = "java(osProcess.getProcessCpuLoadCumulative() * 100)")
    @Mapping(target = "memory", source = "residentSetSize")
    @Mapping(target = "threads", source = "threadCount")
    Process toDomain(OSProcess osProcess);
    List<Process> toDomain(List<OSProcess> osProcess);

}
