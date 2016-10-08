package com.gasmyr.it.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "phonenumber")
public class PhoneNumber {

	public PhoneNumber() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String value;
	@Version
	private Integer version;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
	private Person owner;

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

	public void setOwner(Person person) {
		if (person != null) {
			this.owner = person;
			if (!person.getPhones().contains(this)) {
				person.addPhone(this);
			}
		}
	}

	public Person getOwner() {
		return owner;
	}

}
