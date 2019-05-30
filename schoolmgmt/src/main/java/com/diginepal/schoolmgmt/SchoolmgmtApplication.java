package com.diginepal.schoolmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchoolmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmgmtApplication.class, args);
	}

}
