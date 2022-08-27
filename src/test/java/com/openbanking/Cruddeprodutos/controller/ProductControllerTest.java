//package com.openbanking.Cruddeprodutos.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.RestDocsRestAssuredConfigurationCustomizer;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.openbanking.Cruddeprodutos.controller.dto.ProductDto;
//import com.openbanking.Cruddeprodutos.entidades.Product;
//import com.openbanking.Cruddeprodutos.service.ProductService;
//
//
//public class ProductControllerTest {
//	
//	@Autowired
//	private ProductController productController;
//	
//	@Mock
//	private ProductService productService;
//	
////	@Autowired
////	private MockMvc mockMvc;
//	
//	@BeforeEach
//	public void beforeEach() {
//		MockitoAnnotations.initMocks(this);
//		this.productController = new ProductController(productService); 
//	}
//
//	@Test
//	public void deveriaDevolverAListaDeProdutos() {
//		
//	}
//
//}
