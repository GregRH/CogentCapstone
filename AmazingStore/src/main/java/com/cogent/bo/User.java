package com.cogent.bo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
@Table(name="user")
public class User implements Serializable {
	@Id
	private Long id;
	private String type;
	private String name;
	private String email;
	private String password;
	private Date dob;
	
	@OneToOne
	@JoinColumn(name="cart_id",referencedColumnName = "id")
	private Cart cart;
}
