package com.ttstudios.kalah;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.ttstudios.kalah")
public class ComTtstudiosKalahApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComTtstudiosKalahApplication.class, args);
	}
}
