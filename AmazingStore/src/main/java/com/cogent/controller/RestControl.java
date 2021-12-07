package com.cogent.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cogent.bo.Product;
import com.cogent.dao.ProductDAO;
import com.cogent.service.ProductService;
@RestController
@RequestMapping("rest")
public class RestControl {
	@Autowired
	ProductService productService;
	@Autowired
	ProductDAO dao;
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id){
		Product p = dao.getById(id);
		System.out.println("F");
		return ResponseEntity.ok().body(p);
	}
	@GetMapping("")
	public List<Product> allProducts(){
		System.out.println("Get mapping");
		
		return dao.findAll();
	}
	@PostMapping("/product")
	public ResponseEntity<Object> createNewProduct(@RequestBody Product product){
		//productService.insertProduct(product);
		dao.save(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
