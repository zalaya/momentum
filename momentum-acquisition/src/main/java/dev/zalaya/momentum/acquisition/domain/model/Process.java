package dev.zalaya.momentum.acquisition.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(of = {"name", "path"})
public class Process {

    Integer pid;
    String name;
    String path;
    Double cpu;
    Long memory;
    Integer threads;

}
