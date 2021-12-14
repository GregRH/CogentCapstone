package com.cogent.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.cogent.bo.Order;

public interface OrderDAO extends JpaRepository<Order, Long>{
	Order findByAccountId(@RequestParam("id") Long id);
	
	@Query
	(value="From Order o WHERE o.time = :time")
	public Optional<Order> findOrderByTime(@Param("time") String time);
}
