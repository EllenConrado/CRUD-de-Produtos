package com.openbanking.Cruddeprodutos.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.openbanking.Cruddeprodutos.entidades.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(nativeQuery = true, value = "SELECT * FROM Product WHERE name = :q")
	List<Product> findByName(String q);
	
	@Query (nativeQuery = true,	value = "SELECT * FROM Product WHERE (price <= :max_price AND price >= :min_price) "
			+ "OR (price <= :max_price OR price >= :min_price)")
	List<Product> findByPrice(@Param ("max_price") String max_price, @Param ("min_price") String min_price);
	
//	@Query (nativeQuery = true,	value = "SELECT * FROM Product WHERE price >= :min_price")
//	List<Product> findByPriceMin(@Param ("min_price") String min_price);

	Product getReferenceById(Long id);

}
