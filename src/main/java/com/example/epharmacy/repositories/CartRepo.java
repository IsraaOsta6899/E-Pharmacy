package com.example.epharmacy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.epharmacy.models.Cart;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long> {

}
