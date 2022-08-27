package com.openbanking.Cruddeprodutos.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {


	@Bean
	public Docket crudDeProdutosApi() {
	    return new Docket(DocumentationType.SWAGGER_2)
	        .select()
	        .apis(RequestHandlerSelectors.basePackage("com.openbanking.Cruddeprodutos"))
	        .paths(PathSelectors.any())
	        .build()
	        .apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Documentação da Api")
				.description("CRUD de Produtos")
				.version("1.0.0")
//				.contact(new Contact ("Ellen Cristina Pelissari Conrado","ellenc.conrado@gmail.com"))
				.build();
	}
}
