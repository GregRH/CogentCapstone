package com.cogent.bo;

import java.io.Serializable;
import java.util.List;
import java.util.Locale.Category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@Entity
@Table(name="product")
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	
	private String description;
	private String img;
	//private String category;
	private long quantity;
	private float rating;
	private float price;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="categoryId")
	private Category category;
	@JsonIgnore
	@ManyToMany(mappedBy="products")
	private List<Order> orders;

}
