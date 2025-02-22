package dev.zalaya.collector.domain.port.outbound;

import dev.zalaya.collector.domain.model.Process;

import java.util.List;

public interface ProcessRepository {

    void saveAll(List<Process> processes);

}
