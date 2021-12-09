package com.cogent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bo.Product;
import com.cogent.dao.ProductDAO;

@Service
public class ProductService {
	@Autowired
	ProductDAO productDAO;
	public List<Product> getProductByCategory(String category){
		return productDAO.findByCategory(category);
	}
	public String addProduct( Product product) {
		Product product1 = productDAO.save(product);
		return "success";
		
	}
	
	public void deleteProduct(Product product) {
	
		productDAO.delete(product);
		
	}
	
	public String updateProduct(Product product) {
		
		return "Success" ;
		
	}
	public List<Product> getAllProducts(){
		return productDAO.findAll();
	}
	public Product getProductById(long id) {
		Product product1 = productDAO.getById(id);
		return product1;
	}
	

	
}
