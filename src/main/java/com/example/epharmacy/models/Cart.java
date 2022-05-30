package com.example.epharmacy.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carts")
public class Cart {
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "carts_medicines", 
        joinColumns = @JoinColumn(name = "cart_id"), 
        inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private Set<Medicine> medicines;
	public Set<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(Set<Medicine> medicines) {
		this.medicines = medicines;
	}
}
