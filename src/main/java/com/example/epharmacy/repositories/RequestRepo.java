package com.example.epharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.epharmacy.models.*;

@Repository
public interface RequestRepo extends CrudRepository<Feedback, Long> {
	List<Feedback>findAll();
}
