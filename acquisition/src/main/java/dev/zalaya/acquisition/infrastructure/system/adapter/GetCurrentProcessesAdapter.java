package dev.zalaya.acquisition.infrastructure.system.adapter;

import dev.zalaya.acquisition.domain.model.Process;
import dev.zalaya.acquisition.domain.port.outbound.GetCurrentProcessesUseCase;
import dev.zalaya.acquisition.infrastructure.system.mapper.OSProcessMapper;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import oshi.software.os.OperatingSystem;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GetCurrentProcessesAdapter implements GetCurrentProcessesUseCase {

    private final OperatingSystem operatingSystem;
    private final OSProcessMapper mapper;

    @Override
    public List<Process> getCurrentProcesses() {
        return mapper.toProcesses(operatingSystem.getProcesses());
    }

}
