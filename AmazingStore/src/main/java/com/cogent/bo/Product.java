package com.cogent.bo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
@Table(name="product")
public class Product implements Serializable {
	@Id
	private Long id;
	private String description;
	private String img;
	private String category;
	private long quantity;
	private float rating;
	private float price;
	

}
