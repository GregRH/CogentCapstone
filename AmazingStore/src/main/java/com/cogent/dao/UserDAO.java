package com.cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.bo.User;

public interface UserDAO extends JpaRepository<User, Long>{

}
