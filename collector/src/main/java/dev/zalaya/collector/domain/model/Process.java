package dev.zalaya.collector.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@EqualsAndHashCode(exclude = "memory")
@Getter
@RequiredArgsConstructor
public class Process {

    private final String name;
    private final String path;
    private final Long memory;

}
