package com.example.Monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitoringApplication {
	@Bean
	public EventsService eventsService() {
		return new EventsServiceImpl();
	}
	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
	}
}
