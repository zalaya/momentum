package dev.zalaya.momentum.acquisition.infrastructure.system.adapter;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessProvider;
import dev.zalaya.momentum.acquisition.infrastructure.system.context.OshiContext;
import dev.zalaya.momentum.acquisition.infrastructure.system.mapper.OSProcessMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import oshi.software.os.OSProcess;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProcessProviderAdapter implements ProcessProvider {

    private final OshiContext context;
    private final OSProcessMapper mapper;

    @Override
    public List<Process> getProcesses() {
        List<OSProcess> fetchedOsProcesses = context.getOperatingSystem().getProcesses();

        return mapper.toDomain(fetchedOsProcesses);
    }

}
