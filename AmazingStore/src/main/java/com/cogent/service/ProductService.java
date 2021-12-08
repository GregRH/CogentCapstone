package com.cogent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bo.Product;
import com.cogent.dao.ProductDAO;

@Service
public class ProductService {
	@Autowired
	ProductDAO productDAO;
	
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
	public String getProductById(Product product) {
		Product product1 = productDAO.getById(product);
		
	}
	

	
}
