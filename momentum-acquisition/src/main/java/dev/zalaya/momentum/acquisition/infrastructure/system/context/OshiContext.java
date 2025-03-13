package dev.zalaya.momentum.acquisition.infrastructure.system.context;

import lombok.Getter;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

@Getter
@Component
public class OshiContext {

    private final SystemInfo systemInfo;
    private final OperatingSystem operatingSystem;

    public OshiContext() {
        this.systemInfo = new SystemInfo();
        this.operatingSystem = systemInfo.getOperatingSystem();
    }
}

