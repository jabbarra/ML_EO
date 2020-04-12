package com.obarra.forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForecastApplication {
    /**
     * Main Entry point of Spring boot.
     * @param args variables of environment.
     */
    public static void main(final String[] args) {
        SpringApplication.run(ForecastApplication.class, args);
    }
}
