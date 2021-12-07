package com.cogent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.dao.ProductDAO;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	

}
