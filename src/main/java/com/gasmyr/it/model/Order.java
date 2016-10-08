package com.gasmyr.it.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

//@Entity
//@Table(name = "order")
public class Order implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1004070807057458567L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String key;
	private String description;
	private double amountToPay;
	private double recievedAmount;
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus = PaymentStatus.NotPaid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date currentDate;
	@Version
	private Integer version;
	@ManyToOne
	@JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
	private Shop shop;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}

	public double getRecievedAmount() {
		return recievedAmount;
	}

	public void setRecievedAmount(double recievedAmount) {
		this.recievedAmount = recievedAmount;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
//	public Shop getShop() {
//		return shop;
//	}
//
//	public void setShop(Shop shop) {
//		this.shop = shop;
//	}

	

}
