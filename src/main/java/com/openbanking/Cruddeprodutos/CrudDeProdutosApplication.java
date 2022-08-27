package com.openbanking.Cruddeprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CrudDeProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDeProdutosApplication.class, args);
	}

}
