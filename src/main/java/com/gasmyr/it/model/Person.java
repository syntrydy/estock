package com.gasmyr.it.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "person")
public class Person {

	public Person() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Enumerated(EnumType.STRING)
	private PersonTitle personTitle = PersonTitle.Mr;
	private String firstname;
	private String lastname;
	private String email;
	@Version
	private Integer version;
	@OneToMany(mappedBy = "owner")
	private List<PhoneNumber> phones;
	@Embedded
	private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addPhone(PhoneNumber number) {
		if (!phones.contains(number) && number.getOwner() == this) {
			phones.add(number);
		}
	}

	public List<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}
	

}
