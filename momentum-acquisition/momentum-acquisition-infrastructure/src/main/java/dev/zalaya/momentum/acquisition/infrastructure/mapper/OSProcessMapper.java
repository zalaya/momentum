package dev.zalaya.momentum.acquisition.infrastructure.mapper;

import dev.zalaya.momentum.acquisition.domain.model.Process;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import oshi.software.os.OSProcess;

import java.util.List;

@Mapper
public interface OSProcessMapper {

    @Mapping(target = "pid", source = "processID")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "path", source = "path")
    @Mapping(target = "cpu", expression = "java(osProcess.getProcessCpuLoadCumulative() * 100)")
    @Mapping(target = "memory", expression = "java(osProcess.getResidentSetSize())")
    @Mapping(target = "threads", source = "threadCount")
    Process toProcess(OSProcess osProcess);

    List<Process> toProcesses(List<OSProcess> osProcesses);

}
