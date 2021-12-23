package com.cogent.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.bo.User;
@CrossOrigin()
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserDAO extends JpaRepository<User, Long>{
	@Query
	(value="FROM User u WHERE u.email= :email and u.password = :password")
	public Optional<User> getOne(@Param("email") String email, 
			  @Param("password") String password);
	
	@Query
	(value="FROM User u WHERE u.email= :email")
	public User findByEmail(@Param("email") String email);
	
	Boolean existsByEmail(String email);
}
