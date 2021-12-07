package com.cogent.dto;
<<<<<<< HEAD

import java.util.Date;
=======
import lombok.*;
public class UserDTO {
	private String buyer;
	private String seller;
	
>>>>>>> 198b6e3fce93a94c4140664eac715e3eafcbc85e

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
