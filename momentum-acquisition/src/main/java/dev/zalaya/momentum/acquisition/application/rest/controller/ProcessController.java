package dev.zalaya.momentum.acquisition.application.rest.controller;

import dev.zalaya.momentum.acquisition.application.service.ProcessService;
import dev.zalaya.momentum.acquisition.domain.model.Process;
import dev.zalaya.momentum.acquisition.api.ProcessApi;
import dev.zalaya.momentum.acquisition.model.ProcessDto;
import dev.zalaya.momentum.acquisition.application.rest.mapper.ProcessDtoMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProcessController implements ProcessApi {

    private final ProcessService service;
    private final ProcessDtoMapper mapper;

    @Override
    public ResponseEntity<List<ProcessDto>> getProcesses() {
        List<Process> fetchedProcesses = service.getProcesses();
        List<ProcessDto> mappedProcessDtos = mapper.toDto(fetchedProcesses);

        return ResponseEntity.ok(mappedProcessDtos);
    }

}
