package com.example.epharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.epharmacy.models.Category;



@Repository
public interface CategoryRepo extends CrudRepository<Category, Long>{
	List<Category> findAll();

}
