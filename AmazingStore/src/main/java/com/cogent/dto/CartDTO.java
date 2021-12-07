package com.cogent.dto;

import java.util.List;

import com.cogent.bo.Product;
import com.cogent.bo.User;

public class CartDTO {
	private Long id;
	private User user;
	private List<Product> products;
}
