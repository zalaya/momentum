package dev.zalaya.momentum.acquisition.domain.model;

import lombok.Value;

@Value
public class Process {

    Integer pid;
    String name;
    String path;
    Double cpu;
    Double memory;
    Integer threads;

}
