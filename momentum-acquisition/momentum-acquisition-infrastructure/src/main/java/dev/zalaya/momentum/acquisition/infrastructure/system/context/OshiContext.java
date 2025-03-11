package dev.zalaya.momentum.acquisition.infrastructure.system.context;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

@Component
@Getter
@RequiredArgsConstructor
public class OshiContext {

    private final SystemInfo systemInfo;
    private final OperatingSystem operatingSystem;

}
