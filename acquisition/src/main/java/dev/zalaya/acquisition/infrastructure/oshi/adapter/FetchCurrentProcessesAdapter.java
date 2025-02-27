package dev.zalaya.acquisition.infrastructure.oshi.adapter;

import dev.zalaya.acquisition.domain.model.Process;
import dev.zalaya.acquisition.domain.port.inbound.FetchCurrentProcessesUseCase;

import dev.zalaya.acquisition.infrastructure.oshi.configuration.OshiContext;
import org.springframework.stereotype.Service;

import oshi.software.os.OperatingSystem;

import java.util.List;

@Service
public class FetchCurrentProcessesAdapter implements FetchCurrentProcessesUseCase {

    private final OperatingSystem operatingSystem;

    public FetchCurrentProcessesAdapter(OshiContext context) {
        this.operatingSystem = context.getOperatingSystem();
    }

    @Override
    public List<Process> fetchCurrentProcesses() {
        return List.of();
    }

}
