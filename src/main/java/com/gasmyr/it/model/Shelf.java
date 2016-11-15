package com.gasmyr.it.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "shelf")
public class Shelf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2646529150257790310L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String code;
	private String description;

	@ManyToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
	private Location locationshelf;

	@Version
	private Integer version;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location getLocationshelf() {
		return locationshelf;
	}

	public void setLocationshelf(Location locationshelf) {
		this.locationshelf = locationshelf;
	}

	public void update(Shelf shelf) {
		this.name = shelf.getName();
		this.code = shelf.getCode();
		this.description = shelf.getDescription();
		this.locationshelf = shelf.getLocationshelf();

	}

}
