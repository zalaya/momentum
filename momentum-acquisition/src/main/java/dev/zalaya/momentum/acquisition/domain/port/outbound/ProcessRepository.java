package dev.zalaya.momentum.acquisition.domain.port.outbound;

import dev.zalaya.momentum.acquisition.domain.model.Process;

import java.util.List;

public interface ProcessRepository {

    List<Process> saveAll(List<Process> processes);

}
