package com.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableCaching
@EnableJpaRepositories("com.phoenix.repository")
public class PhoenixApplication {
    public static void main(String[] args) {
        SpringApplication.run(PhoenixApplication.class, args);
    }
}