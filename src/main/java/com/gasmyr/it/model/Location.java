package com.gasmyr.it.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "location")
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4673756453377506072L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String code;
	private String description;
	@Version
	private Integer version;
	@ManyToOne
	@JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
	private Shop locationshop;

	@OneToMany(mappedBy = "locationshelf", cascade = CascadeType.ALL)
	private List<Shelf> shelves;

	public List<Shelf> getShelves() {
		return shelves;
	}

	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Shop getLocationshop() {
		return locationshop;
	}

	public void setLocationshop(Shop locationshop) {
		this.locationshop = locationshop;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void update(Location location) {
		this.name = location.getName();
		this.description = location.getDescription();
		this.code = location.getCode();
		this.locationshop = location.getLocationshop();
	}

	@Override
	public String toString() {
		return this.name + " " + this.code + " " + this.description + " " + this.locationshop.getId();
	}
}
