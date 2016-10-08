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
@Table(name = "category")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1060178291720896567L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	private String description;
	@Version
	private Integer version;
	@ManyToOne
	@JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = true)
	private Category parent;
	@ManyToOne
	@JoinColumn(name = "shop_id", referencedColumnName = "id", nullable = false)
	private Shop owner;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Shop getOwner() {
		return owner;
	}

	public void setOwner(Shop owner) {
		this.owner = owner;
	}

}
