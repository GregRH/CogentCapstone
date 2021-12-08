package com.cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.bo.Cart;

public interface CartDAO extends JpaRepository<Cart, Long>{

}
