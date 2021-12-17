package com.cogent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cogent.bo.User;
import com.cogent.dao.UserDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserDAO userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = this.userRepository.findByEmail(username);
		if(user==null) {
			System.out.println("Not found");
			throw new UsernameNotFoundException("No found");
		}
		
		return user;
	}
	
	

}
