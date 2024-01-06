package com.example1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="mobile")
public class Mobile 
{
@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Column(name="id")

@OneToMany
@JoinColumn(name="customerId")
private Customer customer;
	private int Id;
	@Column(name="name")
	private String name;
	@Column(name="image")
	private String image;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer=customer;
	}
	public Mobile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mobile(int id, String name, String image, Customer customer) {
		super();
		this.Id = id;
		this.name = name;
		this.image = image;
		this.customer = customer;
	}
}
