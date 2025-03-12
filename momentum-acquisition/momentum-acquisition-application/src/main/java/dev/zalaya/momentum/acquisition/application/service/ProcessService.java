package dev.zalaya.momentum.acquisition.application.service;

import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.domain.port.inbound.GetProcessesUseCase;
import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessProvider;
import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProcessService implements GetProcessesUseCase {

    private final ProcessProvider provider;
    private final ProcessRepository repository;

    @Override
    public List<Process> getProcesses() {
        List<Process> fetchedProcesses = provider.getProcesses();
        repository.saveAll(fetchedProcesses);

        return fetchedProcesses;
    }

}
