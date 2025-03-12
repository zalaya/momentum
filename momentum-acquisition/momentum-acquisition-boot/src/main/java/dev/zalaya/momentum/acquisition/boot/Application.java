package dev.zalaya.momentum.acquisition.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "dev.zalaya.momentum.acquisition.infrastructure.persistence.entity")
@EnableJpaRepositories(basePackages = "dev.zalaya.momentum.acquisition.infrastructure.persistence")
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
