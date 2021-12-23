package com.cogent.dto;

import java.util.Date;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class UserDTO {
	private Long id;
	private String type;
	private String name;
	private String email;
	private String password;
	private Date dob;
}
