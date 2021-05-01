package com.vodafone.interview.senior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SeniorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeniorApplication.class, args);
	}

}
