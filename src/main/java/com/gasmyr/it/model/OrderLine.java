package com.gasmyr.it.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

//@Entity
//@Table(name = "orderline")
public class OrderLine {

	public OrderLine() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double quantity;
	private double price;
	private double discount;
	@Version
	private Integer version;
	// @ManyToOne
	// @JoinColumn(name = "order_id", referencedColumnName = "id")
	// private Order owner;
	// @ManyToOne
	// @JoinColumn(name = "product_id", referencedColumnName = "id")
	// private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
