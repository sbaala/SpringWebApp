package com.freebies.Freebies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAsync
@Import(SpringWebInitializer.class)
public class FreebiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreebiesApplication.class, args);
	}
}
