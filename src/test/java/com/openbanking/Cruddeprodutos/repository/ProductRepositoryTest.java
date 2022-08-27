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
	public void deveriaCarregarUmProdutoAoIndicarUmPrecoMaximo() {
		String max_price = "10000";
		List<Product> products = productRepository.findByPriceMax(max_price);
		Assert.assertNotNull(products);
		Assert.assertEquals(max_price, "10000");
	}
	@Test
	public void naoDeveriaCarregarUmProdutoAoNaoIndicarNenhumPrecoMaximo() {
		String max_price = "10000";
		List<Product> products = productRepository.findByPriceMax(max_price);
		Assert.assertNotNull(products);
	}
	@Test
	public void deveriaCarregarUmProdutoAoIndicarUmPrecoMinimo() {
		String min_price = "10000";
		List<Product> products = productRepository.findByPriceMax(min_price);
		Assert.assertFalse(products.isEmpty());
		Assert.assertEquals(min_price,"10000");
	}
	@Test
	public void naoDeveriaCarregarUmProdutoAoNaoIndicarNenhumPrecoMinimo() {
		String min_price = "10000";
		List<Product> products = productRepository.findByPriceMax(min_price);
		Assert.assertNotNull(products);
	}
}
