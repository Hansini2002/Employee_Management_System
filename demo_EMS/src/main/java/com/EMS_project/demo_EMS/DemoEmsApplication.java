package com.EMS_project.demo_EMS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoEmsApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoEmsApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoEmsApplication.class, args);

		log.info("DemoEmsApplication started");
	}

}
