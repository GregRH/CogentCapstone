package com.cogent.bo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
@Entity
@Table(name="cart")
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="prod_id",referencedColumnName = "id")
	private List<Product> products;
	private float total;
}
