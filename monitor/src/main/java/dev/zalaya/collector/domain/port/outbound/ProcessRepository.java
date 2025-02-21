package dev.zalaya.collector.domain.port.outbound;

import dev.zalaya.collector.domain.model.Process;

import java.util.List;

public interface ProcessRepository {

    List<Process> findAll();
    Process findById(Long id);
    Process findByName(String name);
    Process findByPath(String path);
    List<Process> findByMemoryLessThan(Long memory);
    List<Process> findByMemoryGreaterThan(Long memory);
    List<Process> findByMemoryBetween(Long minimumMemory, Long maximumMemory);
    Process save(Process process);

}
