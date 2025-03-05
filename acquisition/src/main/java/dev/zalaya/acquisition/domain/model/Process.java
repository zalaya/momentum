package dev.zalaya.acquisition.domain.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Process {

    Integer pid;
    String name;
    String path;
    Boolean isActive;
    LocalDateTime firstSeen;
    LocalDateTime lastSeen;
    Integer occurrences;

}
