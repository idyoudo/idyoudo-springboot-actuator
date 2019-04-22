package com.idyoudo.springboot.actuator.autoconfigure;

import com.idyoudo.springboot.actuator.customendpoint.RuntimeEndpoint;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuntimeEndpointAutoConfiguration {
    public RuntimeEndpointAutoConfiguration() { }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public RuntimeEndpoint runtimeEndpoint() {
        return new RuntimeEndpoint();
    }
}
