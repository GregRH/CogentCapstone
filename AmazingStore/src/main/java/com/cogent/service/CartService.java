package com.cogent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.bo.Order;
import com.cogent.bo.Product;
import com.cogent.dao.OrderDAO;
@Service
public class CartService {
	@Autowired
	OrderDAO cartDAO;
	

}
