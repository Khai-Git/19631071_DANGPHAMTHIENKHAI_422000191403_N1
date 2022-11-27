package com.MentorService.MentorService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class MentorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentorServiceApplication.class, args);
	}

}
