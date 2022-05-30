package com.example.epharmacy.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="medicines")
public class Medicine {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public boolean isPrescription() {
		return prescription;
	}
	public void setPrescription(boolean prescription) {
		this.prescription = prescription;
	}
	public Date getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
	private String name;
	@Min(1)
	private int quantity;
	@Min(10)
	private float price;
	@NotNull
	private boolean prescription;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date expirydate;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "orders_medicines", 
	        joinColumns = @JoinColumn(name = "medicine_id"), 
	        inverseJoinColumns = @JoinColumn(name = "order_id")
	    )
	    private List<Order> orders;
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="category_id")
	 private Category category;
	public List<Order> getOrders() {
		return orders;
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
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Category getCategory() {
		return category;
	}
	public Set<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "carts_medicines", 
        joinColumns = @JoinColumn(name = "medicine_id"), 
        inverseJoinColumns = @JoinColumn(name = "cart_id")
    )
    private Set<Cart> carts;
	
}
