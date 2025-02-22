package dev.zalaya.collector.adapter.mapper;

import dev.zalaya.collector.domain.model.Process;
import org.springframework.stereotype.Component;
import oshi.software.os.OSProcess;

import java.util.List;

@Component
public class OSProcessMapper {

    public Process toDomain(OSProcess osProcess) {
        return new Process(
            osProcess.getName(),
            osProcess.getPath(),
            osProcess.getResidentSetSize()
        );
    }

    public List<Process> toDomain(List<OSProcess> osProcesses) {
        return osProcesses.stream().map(this::toDomain).toList();
    }

}
