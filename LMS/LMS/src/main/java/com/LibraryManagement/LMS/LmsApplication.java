package com.LibraryManagement.LMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LmsApplication {
	
	public static void main(String[] args) {
	    log.trace("Started the project Successfully... ");
		SpringApplication.run(LmsApplication.class, args);
	}
}
