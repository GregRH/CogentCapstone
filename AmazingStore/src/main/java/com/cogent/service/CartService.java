package com.cogent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bo.Cart;
import com.cogent.bo.Product;
import com.cogent.dao.CartDAO;
@Service
public class CartService {
	@Autowired
	CartDAO cartDAO;
	
	public String addToCart(Cart cart) {
		Cart cart1 = cartDAO.save(cart);
		return "success";
	}
	public void DeleteCart(Cart cart) {
		cartDAO.delete(cart);
	}
	public String addproductToCart(Product p, Cart c) {
		List<Product> l  = c.getProducts();
		l.add(p);
		c.setProducts(l);
		cartDAO.save(c);
		return "";
	}
}
