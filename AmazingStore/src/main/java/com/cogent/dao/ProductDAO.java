package com.cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.bo.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product,Long>{

}
