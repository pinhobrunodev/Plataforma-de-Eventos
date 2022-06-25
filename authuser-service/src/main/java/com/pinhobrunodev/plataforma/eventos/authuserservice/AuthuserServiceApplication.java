package com.pinhobrunodev.plataforma.eventos.authuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuthuserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthuserServiceApplication.class, args);
	}

}
