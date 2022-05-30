package com.example.epharmacy.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.epharmacy.models.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long>{

}
