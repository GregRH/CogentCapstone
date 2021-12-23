package com.cogent.bo;

import java.io.Serializable;
import java.util.List;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="product")
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
	private Long id;
	
	@Column(name = "product_name")
	private String name;
	
	@Column(name = "product_image_url")
	private String productImageURL;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "product_long_description")
	private String productLongDescription;
	
	@Column(name = "product_short_description")
	private String productShortDescription;
	
	@Column(name = "product_rating")
	private double productRating;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="categoryId")
	private Category category;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy="products")
	private List<Order> orders;

}
