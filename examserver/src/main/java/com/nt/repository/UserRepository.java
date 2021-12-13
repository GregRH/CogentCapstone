package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);

}
