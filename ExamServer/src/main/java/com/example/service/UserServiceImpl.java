package com.example.service;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.model.UserRole;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
@Service
public class UserServiceImpl  implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if(local !=null) {
			System.out.println("User is already there");
			throw new Exception();
		} else {
			// user create
			for(UserRole ur :userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			
		}
		return local;
		
		
	}
	
	// getting user by username
	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}
	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
	}

	


}
