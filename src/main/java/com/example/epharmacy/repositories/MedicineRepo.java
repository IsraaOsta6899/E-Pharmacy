package com.example.epharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.epharmacy.models.Medicine;

@Repository
public interface MedicineRepo extends CrudRepository<Medicine, Long> {
	List<Medicine>findAll();
	Medicine findByName(String name);
	List<Medicine> findById(Medicine id);

}
