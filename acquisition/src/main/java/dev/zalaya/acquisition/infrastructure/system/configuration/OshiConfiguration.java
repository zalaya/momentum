package dev.zalaya.acquisition.infrastructure.system.configuration;

import dev.zalaya.acquisition.infrastructure.system.context.OshiContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oshi.SystemInfo;

@Configuration
public class OshiConfiguration {

    @Bean
    public OshiContext defineOshiContextBean() {
        SystemInfo systemInfo = new SystemInfo();

        return new OshiContext(
            systemInfo,
            systemInfo.getOperatingSystem(),
            systemInfo.getHardware()
        );
    }

}
