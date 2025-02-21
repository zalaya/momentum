package dev.zalaya.collector.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Process {

    private final String name;
    private final String path;

}
