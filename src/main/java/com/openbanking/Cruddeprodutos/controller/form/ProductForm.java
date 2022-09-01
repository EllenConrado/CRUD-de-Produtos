package com.openbanking.Cruddeprodutos.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.openbanking.Cruddeprodutos.entidades.Product;
import com.openbanking.Cruddeprodutos.service.ProductService;

public class ProductForm {

	@NotBlank(message="Não pode ser nulo ou vazio") 
	private String name;
	@NotBlank(message="Não pode ser nulo ou vazio") 
	private String description;
	@NotNull(message="Não pode ser nulo") @DecimalMin ("0.00")
	private BigDecimal price;

	public ProductForm(String name, String description, BigDecimal price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public  BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Product converter(ProductService productService) {
		return new Product(name, description, price);
	}
	public Product atualizar(Long id, ProductService productService) {
		Product product = productService.getReferenceById(id);
		product.setName(this.name);
		product.setDescription(this.description);
		product.setPrice(this.price);
		return product;
	}
}
