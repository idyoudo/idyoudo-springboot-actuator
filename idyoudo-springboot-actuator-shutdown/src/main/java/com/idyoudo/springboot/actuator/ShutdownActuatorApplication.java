package com.idyoudo.springboot.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShutdownActuatorApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ShutdownActuatorApplication.class, args);
    }
}
