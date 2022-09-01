package com.openbanking.Cruddeprodutos.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
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
	        .apiInfo(apiInfo())
	        .useDefaultResponseMessages(false)
	        .globalResponseMessage(RequestMethod.GET, responseMessageForGET())
	        .globalResponseMessage(RequestMethod.POST, responseMessageForPOST())
	        .globalResponseMessage(RequestMethod.PUT, responseMessageForPUT())
	        .globalResponseMessage(RequestMethod.DELETE, responseMessageForDELETE());
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Documentação da Api")
				.description("CRUD de Produtos")
				.version("1.0.0")
				.contact(new Contact("Ellen Conrado", "https://github.com/EllenConrado/CRUD-de-Produtos", "ellenc.conrado@gmail.com"))
				.build();
	}
	private List<ResponseMessage> responseMessageForGET(){
		 return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
		{
	        	add(new ResponseMessageBuilder()
	        		.code(400)
	        		.message("Bad Request!")
	        		.responseModel(new ModelRef("ExceptionResponse"))
	        		.build());
		        add(new ResponseMessageBuilder()
		            .code(404)
		            .message("Not Found!")
		            .responseModel(new ModelRef("ExceptionResponse"))
		            .build());
		        add(new ResponseMessageBuilder()
		            .code(500)
		            .message("Internal Server Error!")
		            .responseModel(new ModelRef("ExceptionResponse"))
		            .build());
		 }};
	}
	private List<ResponseMessage> responseMessageForPOST(){
		 return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
		{
		        add(new ResponseMessageBuilder()
		            .code(400)
		            .message("Bad Request!")
		            .responseModel(new ModelRef("ExceptionResponse"))
		            .build());
		        add(new ResponseMessageBuilder()
		            .code(404)
		            .message("Not Found!")
		            .responseModel(new ModelRef("ExceptionResponse"))
		            .build());
		 }};
	}
	private List<ResponseMessage> responseMessageForPUT(){
		 return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
		{
		        add(new ResponseMessageBuilder()
		            .code(400)
		            .message("Bad Request!")
		            .responseModel(new ModelRef("ExceptionResponse"))
		            .build());
		        add(new ResponseMessageBuilder()
		            .code(404)
		            .message("Not Found!")
		            .responseModel(new ModelRef("ExceptionResponse"))
		            .build());
		        add(new ResponseMessageBuilder()
			            .code(500)
			            .message("Internal Server Error!")
			            .responseModel(new ModelRef("ExceptionResponse"))
			            .build());
		 }};
	}
	private List<ResponseMessage> responseMessageForDELETE(){
		 return new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;
		{
		        add(new ResponseMessageBuilder()
		            .code(404)
		            .message("Not Found!")
		            .responseModel(new ModelRef("ExceptionResponse"))
		            .build());
		 }};
	}
}
