package com.cogent.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.bo.User;
import com.cogent.dao.UserDAO;
import com.cogent.exception.ResourceNotFoundException;

@CrossOrigin()
@RequestMapping("/api")
@RestController
public class UserController {
	@Autowired
	private UserDAO userRepository;
	@Autowired
	PasswordEncoder encoder;
	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> usersList = userRepository.findAll();
		return usersList;
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> retrieveUser(@PathVariable long id)throws ResourceNotFoundException {
	    Optional<User> user = Optional.ofNullable(userRepository.findById(id)
	            .orElseThrow(() -> 
	            new ResourceNotFoundException
	            ("User not found for this id : " + id)));
	          return user;
	}
	
	@GetMapping("users/{email}/{password}")
		public Optional<User> getUserByNameAndEmail(
				@PathVariable String email,@PathVariable String password
				) throws ResourceNotFoundException {
		Optional<User> user= Optional.ofNullable(userRepository.getOne(email,password).orElseThrow(() ->
		new ResourceNotFoundException
		("No user found under this name: "+email)));
          return user;	
	}
	
	@PostMapping("/users")
	public String createStudent(@RequestBody User user) {
		userRepository.save(user);
		return "Added successfully!";
	}
	
	@PutMapping("/users/{id}")
	public String updateUser(@RequestBody User user, @PathVariable long id) throws ResourceNotFoundException{
		 User userDetails = userRepository.findById(id)
				 .orElseThrow(()-> new ResourceNotFoundException
		            ("User not found for this id : " + id));
		userDetails.setName(user.getName());
		userDetails.setEmail(user.getEmail());
		userDetails.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(userDetails);
		return "Updated successfully!";
	}
}
