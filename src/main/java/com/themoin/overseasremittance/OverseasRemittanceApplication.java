package com.themoin.overseasremittance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OverseasRemittanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OverseasRemittanceApplication.class, args);
	}

}
