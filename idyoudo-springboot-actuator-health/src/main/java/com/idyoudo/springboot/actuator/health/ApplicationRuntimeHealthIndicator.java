package com.idyoudo.springboot.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 返回程序已经持续运行的时间
 */
//@Component
public class ApplicationRuntimeHealthIndicator implements HealthIndicator {

    public long starttime = 0L;
    public ApplicationRuntimeHealthIndicator(){
        starttime = System.currentTimeMillis() ;
    }

    @Override
    public Health health() {
        long currentTime = System.currentTimeMillis() ;
        long interval = currentTime - starttime;
        return Health.status("Runtime")
                .withDetail("startTime" , starttime)
                .withDetail("currentTime" , currentTime)
                .withDetail("interval" , interval)
                .build();
    }
}