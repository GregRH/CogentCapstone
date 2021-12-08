package com.cogent.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cogent.bo.Cart;
import com.cogent.dao.CartDAO;

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

}
