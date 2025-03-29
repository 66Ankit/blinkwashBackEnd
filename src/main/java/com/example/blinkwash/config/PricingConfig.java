package com.example.blinkwash.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class PricingConfig {

    @Bean
    public Map<String, Map<String, Double>> pricing() {
        return Map.of(
                "Hatchback", Map.of("Basic Wash", 200.0, "Premium Wash", 300.0, "Full Detailing", 500.0),
                "Sedan", Map.of("Basic Wash", 300.0, "Premium Wash", 400.0, "Full Detailing", 600.0),
                "SUV", Map.of("Basic Wash", 300.0, "Premium Wash", 500.0, "Full Detailing", 700.0),
                "Luxury", Map.of("Basic Wash", 300.0, "Premium Wash", 600.0, "Full Detailing", 800.0)
        );
    }

}
