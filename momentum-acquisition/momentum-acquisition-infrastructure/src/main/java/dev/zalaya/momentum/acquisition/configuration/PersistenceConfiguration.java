package dev.zalaya.momentum.acquisition.configuration;

import dev.zalaya.momentum.acquisition.domain.port.outbound.ProcessRepository;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.adapter.ProcessRepositoryAdapter;
import dev.zalaya.momentum.acquisition.infrastructure.persistence.mapper.ProcessEntityMapper;

import dev.zalaya.momentum.acquisition.infrastructure.persistence.repository.ProcessJpaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    @Bean
    public ProcessEntityMapper processEntityMapper() {
        return Mappers.getMapper(ProcessEntityMapper.class);
    }

    @Bean
    public ProcessRepository processRepository(ProcessJpaRepository repository, ProcessEntityMapper mapper) {
        return new ProcessRepositoryAdapter(repository, mapper);
    }

}
