package com.example.epharmacy.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class OrderItem {

	 	
	    private String name;
	    private int quantity;
	    private float price;
	    private int uQuantity;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public int getuQuantity() {
			return uQuantity;
		}
		public void setuQuantity(int uQuantity) {
			this.uQuantity = uQuantity;
		}
	    
	    
	    
	   
}
