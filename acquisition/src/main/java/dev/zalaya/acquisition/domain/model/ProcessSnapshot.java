package dev.zalaya.acquisition.domain.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ProcessSnapshot {

    Double usage;
    Double memory;
    Integer threads;
    LocalDateTime timestamp;

}
