package com.gasmyr.it.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "phonenumber")
public class PhoneNumber {

	public PhoneNumber() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String value;
	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
	private Person person;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
