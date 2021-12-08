package com.cogent.service;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bo.Cart;
import com.cogent.bo.Product;
import com.cogent.bo.User;
import com.cogent.dao.UserDAO;
@Service
public class UserService  {
	@Autowired
	UserDAO userDAO;
	@Autowired
	CartService cartService;
	
	public void addItemToCart(Product product, User user) {
		Cart cart = user.getCart();
		if(cart==null) {
			cart=new Cart();
			cart.setProducts(new ArrayList<Product>());
			
		}
		user.setCart(cart);
		cartService.addproductToCart(product, cart);
		userDAO.save(user);
	}
	
	public String AddUser(User user){
		User user1 = userDAO.save(user);
		return "user added";
		
	}
	public void deleteUser(User user) {
		userDAO.delete(user);
	}
	public List<User> getAllUsers(){
		return userDAO.findAll();
	}

	public User getUserById(long UID) {
		return userDAO.getById(UID);
	}

}
