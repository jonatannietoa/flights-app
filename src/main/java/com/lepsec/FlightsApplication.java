package com.lepsec;

import com.lepsec.configuration.FlightsApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties(FlightsApplicationProperties.class)
@EnableCaching(proxyTargetClass = true)
public class FlightsApplication {
	public static void main(String[] args) {
		SpringApplication.run(FlightsApplication.class, args);
	}
}
