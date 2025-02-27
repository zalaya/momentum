package dev.zalaya.acquisition.infrastructure.oshi.mapper;

import dev.zalaya.acquisition.domain.model.Process;

import oshi.software.os.OSProcess;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProcessMapper {

    @Mapping(target = "pid", source = "processID")
    @Mapping(target = "threads", source = "threadCount")
    @Mapping(target = "usage", expression = "java(mapUsage(osProcess.getProcessCpuLoadCumulative() * 100))")
    Process toProcess(OSProcess osProcess);

    List<Process> toProcesses(List<OSProcess> osProcesses);

}
