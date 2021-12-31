package com.src;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrueMedsProjectApplication {
	
	private static final Logger LOGGER= LogManager.getLogger(TrueMedsProjectApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrueMedsProjectApplication.class, args);
	}

}
