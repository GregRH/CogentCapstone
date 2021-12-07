package com.cogent.dto;

import java.util.List;

import com.cogent.bo.Product;
import com.cogent.bo.User;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class CartDTO {
	private Long id;
	private User user;
	private List<Product> products;
}
