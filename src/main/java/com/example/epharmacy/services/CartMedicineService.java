package com.example.epharmacy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.epharmacy.models.Cart;
import com.example.epharmacy.models.Carts_Medicines;
import com.example.epharmacy.repositories.CartsMedicineRepo;

@Service
public class CartMedicineService {
private final CartsMedicineRepo cartsMedicineRepo;
public CartMedicineService( CartsMedicineRepo cartsMedicineRepo) {
	this.cartsMedicineRepo=cartsMedicineRepo;
}

public List<Carts_Medicines>getAll(){
	return cartsMedicineRepo.findAll();
}
public List<Carts_Medicines>getAllItemsInThisCart(Cart cart){
	 return cartsMedicineRepo.findByCart(cart);
}
public void add(Carts_Medicines c) {
	cartsMedicineRepo.save(c);
	return;
}
public void deleteElement(Carts_Medicines cm) {
	cartsMedicineRepo.delete(cm);
	return;
}
}
