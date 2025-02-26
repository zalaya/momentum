package dev.zalaya.acquisition.domain.port.inbound;

import dev.zalaya.acquisition.domain.model.Process;

import java.util.List;

public interface FetchCurrentProcessesUseCase {

    List<Process> fetchCurrentProcesses();

}
