package com.cogent.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.bo.User;
import com.cogent.config.JwtUtils;
import com.cogent.dao.UserDAO;
import com.cogent.dto.JwtRequest;
import com.cogent.dto.JwtResponse;
import com.cogent.dto.LoginRequest;
import com.cogent.dto.SignupRequest;
import com.cogent.exception.UserNotFoundException;
import com.cogent.service.UserDetailsImpl;
import com.cogent.service.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	UserDAO accountRepository;
	@Autowired
	private JwtUtils jwtUtil;
	
	@PostMapping("/signin")
	public ResponseEntity<?>generateToken(@RequestBody LoginRequest loginRequest)throws Exception{
		try {
			authenticate(loginRequest.getEmail(),loginRequest.getPassword());
		}catch(UserNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		String jwt = jwtUtil.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		System.out.println("Loging in::"+ userDetails.getUsername()+"::"+roles);
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
	private void authenticate(String username, String password)throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e) {
			throw new Exception("User dissabled");
		}catch(Exception e) {
			throw new Exception("Invalid credentials");
		}
	}
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return ((User)this.userDetailsServiceImpl.loadUserByUsername(principal.getName()));
	}
	
	@PostMapping("/ssignin")
	public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) throws Exception {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtil.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		System.out.println("Loging in::"+ userDetails.getUsername()+"::"+roles);
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {

		if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Email is already in use!");
		}
		
		// Create new user's account
		User user = new User();
		user.setName(signUpRequest.getFullName());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setType(signUpRequest.getAccountType());
		user.setEmail(signUpRequest.getEmail());
		
				//new User(signUpRequest.getFullName(), 
						//	 signUpRequest.getEmail(),
					//		 encoder.encode(signUpRequest.getPassword()), signUpRequest.getAccountType(),signUpRequest.getDateOfBirth());

		accountRepository.save(user);
		return ResponseEntity.ok("User registered successfully!");
	}

}
