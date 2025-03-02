package dev.zalaya.acquisition.infrastructure.system.configuration;

import lombok.Value;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

@Value
public class OshiContext {

    SystemInfo systemInfo;
    OperatingSystem operatingSystem;
    HardwareAbstractionLayer hardwareAbstractionLayer;

}
