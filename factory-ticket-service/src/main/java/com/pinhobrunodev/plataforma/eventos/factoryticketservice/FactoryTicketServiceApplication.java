package com.pinhobrunodev.plataforma.eventos.factoryticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FactoryTicketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryTicketServiceApplication.class, args);
	}

}
