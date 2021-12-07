package com.cogent.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Entity
@Table(name="cart")
public class Cart implements Serializable {
	@Id
	private Long id;
	private User user;
	private List<Product> products;
	private float total;
}
