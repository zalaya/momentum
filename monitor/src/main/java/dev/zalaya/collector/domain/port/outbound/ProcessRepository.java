package dev.zalaya.collector.domain.port.outbound;

import dev.zalaya.collector.domain.model.Process;

import java.util.List;

public interface ProcessRepository {

    List<Process> findAll();
    Process findById(Long id);
    Process save(Process process);
    List<Process> saveAll(List<Process> processes);

}
