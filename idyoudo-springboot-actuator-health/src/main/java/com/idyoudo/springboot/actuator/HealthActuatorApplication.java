package com.idyoudo.springboot.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HealthActuatorApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HealthActuatorApplication.class, args);
    }
}
