package com.cogent.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.cogent.bo.Order;
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "orders", path = "order")
public interface OrderDAO extends JpaRepository<Order, Long>{
	//Order findByAccountId(@RequestParam("id") Long id);
	
	@Query
	(value="From Order o WHERE o.time = :time")
	public Optional<Order> findOrderByTime(@Param("time") String time);
}
