package com.cogent.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cogent.bo.User;

public interface UserDAO extends JpaRepository<User, Long>{
	@Query
	(value="FROM User u WHERE u.email= :email and u.password = :password")
	public Optional<User> getOne(@Param("email") String email, 
			  @Param("password") String password);
	
	@Query
	(value="FROM User u WHERE u.email= :email")
	public Optional<User> findByEmail(@Param("email") String email);
	
	Boolean existsByEmail(String email);
}
