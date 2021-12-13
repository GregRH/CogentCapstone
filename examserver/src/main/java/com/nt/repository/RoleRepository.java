package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
