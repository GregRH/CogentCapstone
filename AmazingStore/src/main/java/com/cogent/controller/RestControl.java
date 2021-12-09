package com.cogent.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cogent.bo.Cart;
import com.cogent.bo.Product;
import com.cogent.bo.User;
import com.cogent.service.CartService;
import com.cogent.service.ProductService;
import com.cogent.service.UserService;
@RestController
@RequestMapping("rest")
@CrossOrigin(origins="http://localhost:4200")
public class RestControl {
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	@Autowired
	CartService cartService;
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id){
		Product p = productService.getProductById(id);
		System.out.println("F");
		return ResponseEntity.ok().body(p);
	}
	@GetMapping("/")
	public List<Product> allProducts(){
		System.out.println("Get mapping");
		
		return productService.getAllProducts();
	}
	@PostMapping("/product")
	public ResponseEntity<Object> createNewProduct(@RequestBody Product product){
		productService.addProduct(product);
		String id = ""+product.getId();
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/user")
	public ResponseEntity<Object> createUser(@RequestBody User user){
		String id=""+user.getId();
		userService.AddUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	@PostMapping("/delete/user/{id}")
	public String deleteUser(@PathVariable long id) {
		userService.deleteUser(userService.getUserById(id));
		return "Deleted";
	}
	@PostMapping("/delete/cart/{id}")
	public String deleteCart(@PathVariable long id) {
		User user = userService.getUserById(id);
		Cart cart = user.getCart();
		//cartService.DeleteCart(cart);
		user.setCart(null);
		userService.AddUser(user);
		return "Deleted";
	}
}
