package com.diegodossantos95.mmps.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -3275552243704225648L;

	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject == null)
			return false;
		
		Long objectId = ((AbstractModel) otherObject).getId();
		
		if (this.id == null && objectId == null) {
			return true;
		}
		
		if (this.id != null && objectId != null) {
			if (this.id.equals(objectId)) {
				return true;
			}
		}
		
		return false;
	}
}