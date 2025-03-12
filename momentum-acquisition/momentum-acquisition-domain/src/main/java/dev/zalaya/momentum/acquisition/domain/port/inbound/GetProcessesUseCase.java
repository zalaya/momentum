package dev.zalaya.momentum.acquisition.domain.port.inbound;

import dev.zalaya.momentum.acquisition.domain.model.Process;

import java.util.List;

public interface GetProcessesUseCase {

    List<Process> getProcesses();

}
