package com.example.epharmacy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.epharmacy.models.Order;
import com.example.epharmacy.repositories.OrderRepo;

@Service
public class OrderService {
	private final OrderRepo orderRepo;
	public OrderService(OrderRepo orderRepo) {
		this.orderRepo=orderRepo;
	}
public void addNewOrder(Order o) {
	orderRepo.save(o);
	return;
}
public List<Order>getAllOrders(){
	List<Order>aList= (List<Order>) orderRepo.findAll();
	return aList;
}
public Order findOrderById(Long id) {
	Optional<Order> order= orderRepo.findById(id);
	return order.get();
}
public void deleteOrder(Order order) {
	orderRepo.delete(order);
	return;
}
}
