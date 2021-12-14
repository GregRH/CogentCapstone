package com.cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cogent.bo.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long> {

}
