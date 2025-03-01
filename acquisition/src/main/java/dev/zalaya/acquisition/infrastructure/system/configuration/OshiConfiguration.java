package dev.zalaya.acquisition.infrastructure.system.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oshi.SystemInfo;

@Configuration
public class OshiConfiguration {

    @Bean
    public OshiContext defineOshiContextBean() {
        SystemInfo systemInfo = new SystemInfo();

        return OshiContext.builder()
            .systemInfo(systemInfo)
            .operatingSystem(systemInfo.getOperatingSystem())
            .hardwareAbstractionLayer(systemInfo.getHardware())
            .build();
    }

}
