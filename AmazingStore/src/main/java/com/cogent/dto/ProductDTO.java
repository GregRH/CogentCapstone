package com.cogent.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDTO {
	private Long id;
	private String description;
	private String img;
	private String category;
	private long quantity;
	private float rating;
	private float price;
}
