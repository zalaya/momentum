package dev.zalaya.collector.domain.model;

import java.util.Objects;

public class Process {

    private final String name;
    private final String path;

    public Process(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Process process)) {
            return false;
        }

        return Objects.equals(name, process.name) && Objects.equals(path, process.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, path);
    }

}
