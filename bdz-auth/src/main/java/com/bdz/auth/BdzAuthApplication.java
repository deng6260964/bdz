package com.bdz.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.bdz.*"})
public class BdzAuthApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BdzAuthApplication.class);
//    springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);
	}
}
