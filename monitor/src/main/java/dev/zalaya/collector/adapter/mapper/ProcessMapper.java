package dev.zalaya.collector.adapter.mapper;

import dev.zalaya.collector.domain.model.Process;
import dev.zalaya.collector.infrastructure.persistence.entity.ProcessEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessMapper {

    public Process toDomain(ProcessEntity entity) {
        return new Process(
            entity.getName(),
            entity.getPath(),
            entity.getMemory()
        );
    }

    public List<Process> toDomain(List<ProcessEntity> entities) {
        return entities.stream().map(this::toDomain).toList();
    }

    public ProcessEntity toEntity(Process domain) {
        return new ProcessEntity(
            null,
            domain.getName(),
            domain.getPath(),
            domain.getMemory()
        );
    }

    public List<ProcessEntity> toEntity(List<Process> domains) {
        return domains.stream().map(this::toEntity).toList();
    }

}
