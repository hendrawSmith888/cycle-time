package com.sinarmas.backend.cycletime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableConfigurationProperties
public class CycletimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CycletimeApplication.class, args);
	}

}
