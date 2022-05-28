package com.example.epharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.epharmacy.models.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
	List<Role>findAll();
}
