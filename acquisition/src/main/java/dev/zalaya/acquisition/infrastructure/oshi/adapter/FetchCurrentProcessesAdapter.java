package dev.zalaya.acquisition.infrastructure.oshi.adapter;

import dev.zalaya.acquisition.domain.model.Process;
import dev.zalaya.acquisition.domain.port.inbound.FetchCurrentProcessesUseCase;
import dev.zalaya.acquisition.infrastructure.oshi.configuration.OshiContext;
import dev.zalaya.acquisition.infrastructure.oshi.mapper.ProcessMapper;

import org.springframework.stereotype.Service;
import oshi.software.os.OperatingSystem;

import java.util.List;

@Service
public class FetchCurrentProcessesAdapter implements FetchCurrentProcessesUseCase {

    private final OperatingSystem operatingSystem;
    private final ProcessMapper mapper;

    public FetchCurrentProcessesAdapter(OshiContext context, ProcessMapper mapper) {
        this.operatingSystem = context.getOperatingSystem();
        this.mapper = mapper;
    }

    @Override
    public List<Process> fetchCurrentProcesses() {
        return mapper.toProcesses(operatingSystem.getProcesses());

    }

}
