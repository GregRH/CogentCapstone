package com.cogent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cogent.bo.Category;
@CrossOrigin()
@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryDAO extends JpaRepository<Category, Long> {

}
