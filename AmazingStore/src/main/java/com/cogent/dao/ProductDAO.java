package com.cogent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.cogent.bo.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product,Long>{
//	@Query("SELECT p FROM Product p WHERE p.category = :category")
//	List<Product> findByCategory(@Param("category")String category);
	
	@Query("from Product p where p.name LIKE '%'||:name||'%'")
	public List<Product> findProductByName(@Param("name") String name);
	
	Product findByCategoryId(@RequestParam("id") Long id);
	Product findByNameContaining(@RequestParam("name") String name);
	Product findByOrdersId(@RequestParam("id") Long id);
}
