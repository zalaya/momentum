package dev.zalaya.momentum.acquisition.infrastructure.system.context;

import lombok.Getter;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

@Component
@Getter
public class OshiContext {

    private final SystemInfo systemInfo;
    private final OperatingSystem operatingSystem;

    public OshiContext() {
        systemInfo = new SystemInfo();
        operatingSystem = systemInfo.getOperatingSystem();
    }

}
