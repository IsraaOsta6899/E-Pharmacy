package com.example.epharmacy.models;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="carts_medicines")
public class Carts_Medicines {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    private int number_of_items;
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="cart_id")
	    private Cart cart;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="medicine_id")
	    private Medicine medicine;
	    
	    public Carts_Medicines() {
	        
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}

		public int getNumber_of_items() {
			return number_of_items;
		}

		public void setNumber_of_items(int number_of_items) {
			this.number_of_items = number_of_items;
		}

		public Cart getCart() {
			return cart;
		}

		public void setCart(Cart cart) {
			this.cart = cart;
		}

		public Medicine getMedicine() {
			return medicine;
		}

		public void setMedicine(Medicine medicine) {
			this.medicine = medicine;
		}
	  
	}
