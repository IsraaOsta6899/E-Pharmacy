package com.example.epharmacy.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.epharmacy.models.Cart;
import com.example.epharmacy.repositories.CartRepo;

@Service
public class CartService {
private final CartRepo cartRepo;
public CartService(CartRepo cartRepo) {
	this.cartRepo=cartRepo;
}
public Cart updateCart(Cart cart) {
	
	return cartRepo.save(cart);
}
public Cart getCartById(Long id) {
	Optional<Cart> cart= cartRepo.findById(id);
	return cart.get();
}
}
