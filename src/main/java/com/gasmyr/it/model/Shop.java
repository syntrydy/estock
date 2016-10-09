package com.gasmyr.it.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "shop")
public class Shop implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6503130601922044400L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String email;
	private String phonenumber;
	private String website;
	private Boolean isactive;
	private String logo;
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Version
	private Integer version;
	@OneToMany(mappedBy = "categoryshop", cascade = CascadeType.ALL)
	private List<Category> categories;
	
	@OneToMany(mappedBy = "locationshop", cascade = CascadeType.ALL)
	private List<Location> locations;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Boolean isIsactive() {
		return isactive;
	}

	
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}

	public void update(Shop shop) {
		this.name = shop.getName();
		this.description = shop.getDescription();
		this.email = shop.getEmail();
		this.phonenumber = shop.getPhonenumber();
		this.website = shop.getWebsite();
		this.isactive = shop.isIsactive();
		this.logo=shop.getLogo();
	}

}
