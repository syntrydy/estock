package com.gasmyr.it.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

//@Entity
public class Customer  extends Person{

	public Customer() {
	}
    @OneToMany(mappedBy = "customer")
	private List<Order> orders;

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
