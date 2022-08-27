package com.openbanking.Cruddeprodutos.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openbanking.Cruddeprodutos.entidades.Product;
import com.openbanking.Cruddeprodutos.repository.ProductRepository;
import com.openbanking.Cruddeprodutos.service.exception.BadRequestException;
import com.openbanking.Cruddeprodutos.service.exception.InternalServerErrorException;
import com.openbanking.Cruddeprodutos.service.exception.NotFoundException;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//Get({/products})
	public List<Product> findAll() {
		try {
			return productRepository.findAll();
		}catch(NoSuchElementException e) {
			throw new InternalServerErrorException("internal server error");
		}
	}
	
	//Get({/search?q})
	public List<Product> findByName(String q) {
		try {
			return productRepository.findByName(q);
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new BadRequestException ("bad request");
		}catch(NoSuchElementException e) {
			throw new InternalServerErrorException("internal server error");
		}
	}
	//Get({/search?max_price})
	public List<Product> findByPriceMax(String max_price) {
		try {
			return productRepository.findByPriceMax(max_price);
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new BadRequestException ("bad request");
		}catch(NoSuchElementException e) {
			throw new InternalServerErrorException("internal server error");
		}
	}
	//Get({/search?min_price})
	public List<Product> findByPriceMin(String min_price) {
		try {
			return productRepository.findByPriceMin(min_price);
		}catch(ArrayIndexOutOfBoundsException e) {
			throw new BadRequestException ("bad request");
		}catch(NoSuchElementException e) {
			throw new InternalServerErrorException("internal server error");
		}
		
	}
	
	//Get(/{id})
	public Product findById(Long id) {
		try {
			if(productRepository.existsById(id)) {
				return productRepository.findById(id).get();
			}else {
				throw new NotFoundException ("not found"+id);
			}
		}catch(NoSuchElementException e) {
			throw new InternalServerErrorException("internal server error"+id);
		}
		
	}
	
	//Post
	public Product save(Product product) {
		try {
			return productRepository.save(product);
		}catch(NoSuchElementException e) {
			throw new InternalServerErrorException("internal server error");
		}
	}
	
	//Put(/{id})
	public Product getReferenceById(Long id) {
		try {
			if(productRepository.existsById(id)) {
				return productRepository.getReferenceById(id);
			}else {
				throw new NotFoundException ("not found"+id);
			}
		}catch(NoSuchElementException e) {
			throw new InternalServerErrorException("internal server error"+id);
		}
		
	}
	//Delete(/{id})
	public void deleteById(Long id) {
			if(productRepository.existsById(id)) {
			productRepository.deleteById(id);
			}else {
				throw new NotFoundException ("not found"+id);
			}
	}
}
