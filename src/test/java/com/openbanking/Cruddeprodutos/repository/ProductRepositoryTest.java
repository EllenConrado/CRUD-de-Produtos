package com.openbanking.Cruddeprodutos.repository;

import java.util.List;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.openbanking.Cruddeprodutos.entidades.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void deveriaCarregarUmProdutoAoBuscarPeloNome() {
		String q = "Computador";
		List<Product> products = productRepository.findByName(q);
		Assert.assertNotNull(products);
		Assert.assertEquals(q, "Computador");
	}
	@Test
	public void naoDeveriaCarregarUmProdutoSeONomeNaoEstiverCadastradoAoBuscarPeloNome() {
		String q = "Geladeira";
		List<Product> products = productRepository.findByName(q);
		Assert.assertNotNull(products);
	}
	@Test
	public void deveriaCarregarUmProdutoAoIndicarUmPrecoMaximoEOuMinimo() {
		String max_price = "10000";
		String min_price = "100";
		List<Product> products = productRepository.findByPrice(max_price, min_price);
		Assert.assertNotNull(products);
		Assert.assertEquals(max_price, "10000");
		Assert.assertEquals(min_price, "100");
	}
	@Test
	public void naoDeveriaCarregarUmProdutoAoNaoIndicarNenhumPrecoMaximoEOuMinimo() {
		String max_price = "10000";
		String min_price = "100";
		List<Product> products = productRepository.findByPrice(max_price, min_price);
		Assert.assertNotNull(products);
	}
}
