package dev.zalaya.acquisition.domain.model;

import lombok.Value;

@Value
public class Process {

    Integer pid;
    String name;
    String path;
    Double usage;
    Integer threads;

}