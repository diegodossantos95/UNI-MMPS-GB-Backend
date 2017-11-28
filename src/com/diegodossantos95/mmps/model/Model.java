package com.diegodossantos95.mmps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Model {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String initials;
	
	@OneToMany(mappedBy="model", fetch=FetchType.EAGER)
	private List<ProcessArea> processAreas;
	
	@OneToMany(mappedBy="model", fetch=FetchType.EAGER)
	private List<GenericGoal> genericGoals;

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

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}

	public List<ProcessArea> getProcessAreas() {
		return processAreas;
	}

	public void setProcessAreas(List<ProcessArea> processAreas) {
		this.processAreas = processAreas;
	}
	
	public List<GenericGoal> getGenericGoals() {
		return genericGoals;
	}

	public void setGenericGoals(List<GenericGoal> genericGoals) {
		this.genericGoals = genericGoals;
	}
}
