package com.openbanking.Cruddeprodutos.service;

import static org.mockito.ArgumentMatchers.anyLong;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.openbanking.Cruddeprodutos.entidades.Product;
import com.openbanking.Cruddeprodutos.repository.ProductRepository;
import com.openbanking.Cruddeprodutos.service.exception.NotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTest {
	
	@MockBean
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;

//	@Test
//	public void naoDeveriaDevolverNenhumProdutoAoCarregarPeloId() {
//		Long id = (long) 1;
//		Optional<Product> product = Optional.of(criarProduct());
//		Mockito.when(productRepository.findById(ArgumentMatchers.eq(id))).thenReturn(product);
//		productService.deleteById(id);
//	}
	
	private Product criarProduct() {
		Product product = Mockito.mock(Product.class);
		Long id = (long) 1;
		Mockito.when(productRepository.findById(id)).thenReturn(null);
		Mockito.when(productRepository.findById(anyLong())).thenThrow(new NotFoundException ("not found"));
		return product;
	}
	@Test
	public void deveriaDevolverUmProdutoAoCarregarPeloNome() {
		String q ="Compuador";
		List<Product> product = List.of(criarProduct());
		Mockito.when(productRepository.findByName(ArgumentMatchers.eq(q))).thenReturn(product);
		productService.findByName(q);
	}
	@Test
	public void deveriaDevolverUmProdutoAoCarregarPeloPreçoMaximo() {
		String max_price = "10000.00";
		List<Product> product = List.of(criarProduct());
		Mockito.when(productRepository.findByName(ArgumentMatchers.eq(max_price))).thenReturn(product);
		productService.findByPriceMax(max_price);
	}

}
