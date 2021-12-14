package com.cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cogent.bo.Category;

public interface CategoryDAO extends JpaRepository<Category, Long> {

}
