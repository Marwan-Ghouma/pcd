package net.codejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootEmailVerificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmailVerificationApplication.class, args);
	}

}
