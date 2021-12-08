package com.cogent.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cogent.bo.User;
import com.cogent.dao.UserDAO;

public class UserService  {
	@Autowired
	UserDAO userDAO;
	
	public String AddUser(User user) throws Exception{
		User user1 = userDAO.save(user);
		return "user added";
		
	}
	public void deleteUser(User user) {
		userDAO.delete(user);
	}

}
