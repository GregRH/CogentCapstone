package com.cogent.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Entity
@Table(name="orders")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long id;
	private boolean paid;
	private boolean shipped;
	private String shippingAddress;
	private String time;
	
	@ManyToMany
	@JoinTable(
			name="orders_products",
			joinColumns = @JoinColumn(name="order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id")
			)
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
}
