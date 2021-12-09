package com.cogent.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.bo.Cart;
import com.cogent.bo.Product;
import com.cogent.bo.User;
import com.cogent.service.ProductService;
import com.cogent.service.UserService;

@RestController
@RequestMapping("test")
public class TestingContoller {
	@Autowired
	UserService userService;
	@Autowired
	ProductService productService;
	
	@PostMapping("/{userId}/{itemId}/add")
	public String addToCart(@PathVariable long userId, @PathVariable long itemId) {
		User user = userService.getUserById(itemId);
		Product product = productService.getProductById(itemId);
		System.out.println(user+"\n"+product);
		userService.addItemToCart(product, user);
		return "added";
	}
	
	@GetMapping("/{userId}/{itemId}")
	public String viewItem(@PathVariable long userId, @PathVariable long itemId) {
		Product p = productService.getProductById(itemId);
		return p.toString();
	}
	@GetMapping("/{userId}/cart")
	public String viewCart(@PathVariable long userId) {
		User user = userService.getUserById(userId);
		Cart c = user.getCart();
		return c.toString();
	}
	
	@GetMapping("/{userId}/items/{category}")
	public String getView(@PathVariable long userId, @PathVariable String category, HttpServletResponse response) {
		User user= userService.getUserById(userId);
		if(user.getType().equalsIgnoreCase("buyer")) {
			//show buyer view
			try {
				response.sendRedirect("/test/"+userId+"/buyer/items/"+category);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/{userId}/buyer/{category}";
			
		}else if(user.getType().equalsIgnoreCase("seller")) {
			//show seller view
			return "redirect:/{userId}/seller/{category}";
		}else
			return "redirect:/";
	}
	@GetMapping("/{userId}/buyer/items/{category}")
	public String getBuyerView(@PathVariable String category) {
		List<Product> products = productService.getProductByCategory(category);
		return products.toString();
	}
	@GetMapping("/{userId}/seller/items/{category}")
	public String getSellerView(@PathVariable String category) {
		return "";
	}
}
