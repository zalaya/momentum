package dev.zalaya.momentum.acquisition.infrastructure.rest.controller;

import dev.zalaya.momentum.acquisition.application.service.ProcessService;
import dev.zalaya.momentum.acquisition.domain.model.Process;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProcessController  {

    private final ProcessService service;

    public ResponseEntity<List<Process>> getProcesses() {
        List<Process> fetchedProcesses = service.getProcesses();

        return ResponseEntity.ok(fetchedProcesses);
    }

}
