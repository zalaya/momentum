package dev.zalaya.acquisition.domain.port.outbound;

import dev.zalaya.acquisition.domain.model.Process;

import java.util.List;

public interface GetCurrentProcessesUseCase {

    List<Process> getCurrentProcesses();

}
