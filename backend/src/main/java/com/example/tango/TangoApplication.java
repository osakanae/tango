package com.example.tango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TangoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TangoApplication.class, args);
	}

}
