package com.cogent.service;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bo.Order;
import com.cogent.bo.Product;
import com.cogent.bo.User;
import com.cogent.dao.UserDAO;
@Service
public class UserService  {
	@Autowired
	UserDAO userDAO;
	
}
