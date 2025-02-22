package dev.zalaya.collector.application.service;

import dev.zalaya.collector.infrastructure.adapter.mapper.OSProcessMapper;
import dev.zalaya.collector.domain.model.Process;
import dev.zalaya.collector.domain.port.inbound.ProcessAcquisitionPort;
import dev.zalaya.collector.domain.port.outbound.ProcessRepository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import oshi.SystemInfo;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;

import java.util.List;

@Service
public class ProcessAcquisitionService implements ProcessAcquisitionPort {

    private final OSProcessMapper mapper;
    private final ProcessRepository repository;
    private final SystemInfo systemInformation;

    public ProcessAcquisitionService(OSProcessMapper mapper, ProcessRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
        this.systemInformation = new SystemInfo();
    }

    @Override
    @Scheduled(cron = "*/1 * * * * *")
    public void acquire() {
        OperatingSystem os = systemInformation.getOperatingSystem();

        List<OSProcess> osProcesses = os.getProcesses();
        List<Process> processes = mapper.toDomain(osProcesses);

        repository.saveAll(processes);
    }

}
