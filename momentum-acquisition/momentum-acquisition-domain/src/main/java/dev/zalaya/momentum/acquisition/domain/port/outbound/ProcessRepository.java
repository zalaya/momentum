package dev.zalaya.momentum.acquisition.domain.port.outbound;

import dev.zalaya.momentum.acquisition.domain.model.Process;

public interface ProcessRepository {

    Process save(Process process);

}
