package com.example.epharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.epharmacy.models.Cart;
import com.example.epharmacy.models.Carts_Medicines;

@Repository
public interface CartsMedicineRepo extends CrudRepository<Carts_Medicines, Long>{
	List<Carts_Medicines>findAll();
	List<Carts_Medicines>findByCart(Cart cart);

}
