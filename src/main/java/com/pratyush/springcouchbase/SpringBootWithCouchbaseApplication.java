package com.pratyush.springcouchbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootWithCouchbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithCouchbaseApplication.class, args);
		log.info("--Application Strated Successfully---");
		System.err.println("From Main Method : --Application Strated Successfully---");
	}

}
