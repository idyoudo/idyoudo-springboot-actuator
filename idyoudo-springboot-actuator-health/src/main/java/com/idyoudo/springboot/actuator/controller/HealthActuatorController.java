package com.idyoudo.springboot.actuator.controller;

import com.idyoudo.springboot.actuator.property.ConfigProperty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HealthActuatorController {

	@Resource
	public ConfigProperty configProperty = null;

	@RequestMapping("/helloactuator")
	public String helloactuator(){
		return configProperty.toString();
	}
}
