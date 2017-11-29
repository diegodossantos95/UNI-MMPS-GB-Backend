package com.diegodossantos95.mmps.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Category extends AbstractModel {
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String name;	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
