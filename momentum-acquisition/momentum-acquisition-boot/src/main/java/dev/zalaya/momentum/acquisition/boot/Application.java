package dev.zalaya.momentum.acquisition.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
    "dev.zalaya.momentum.acquisition.domain",
    "dev.zalaya.momentum.acquisition.application",
    "dev.zalaya.momentum.acquisition.infrastructure",
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
