package dev.zalaya.acquisition.infrastructure.system.configuration;

import lombok.Builder;
import lombok.Value;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

@Value
@Builder
public class OshiContext {

    SystemInfo systemInfo;
    OperatingSystem operatingSystem;
    HardwareAbstractionLayer hardwareAbstractionLayer;

}
