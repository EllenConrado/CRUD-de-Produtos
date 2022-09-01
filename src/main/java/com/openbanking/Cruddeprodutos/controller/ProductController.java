package com.openbanking.Cruddeprodutos.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.openbanking.Cruddeprodutos.controller.dto.ProductDto;
import com.openbanking.Cruddeprodutos.controller.form.ProductForm;
import com.openbanking.Cruddeprodutos.entidades.Product;
import com.openbanking.Cruddeprodutos.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductDto> lista(){
		List<Product> products = productService.findAll();
		return ProductDto.converter(products);
	}
	@GetMapping(value = "/search")
	public List<ProductDto> filtro(String q, String max_price, String min_price) {
			if(q != null) {
				List<Product> products = productService.findByName(q);
				return ProductDto.converter(products);			
			} else {
//				if((max_price != null) && (min_price != null)) {
					List<Product> products = productService.findByPrice(max_price, min_price);
					return ProductDto.converter(products);	
			}
		}			
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> cadastrar (@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
		Product product = form.converter(productService);
		productService.save(product);
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDto> detalhar(@PathVariable Long id) {
			Product product = productService.findById(id);
			return ResponseEntity.ok(new ProductDto(product));
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<ProductDto> atualizar(@PathVariable Long id,
			@RequestBody @Valid ProductForm form) {
		Product product = form.atualizar(id, productService);
		return ResponseEntity.ok(new ProductDto(product));
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		productService.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
