package com.diegodossantos95.mmps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GenericGoal {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String initials;
	
	@ManyToOne
	@JoinColumn
	private CapabilityLevel capabilityLevel;
	
	@ManyToOne
	@JoinColumn
	private ProcessArea processArea;

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

	public CapabilityLevel getCapabilityLevel() {
		return capabilityLevel;
	}

	public void setCapabilityLevel(CapabilityLevel capabilityLevel) {
		this.capabilityLevel = capabilityLevel;
	}

	public ProcessArea getProcessArea() {
		return processArea;
	}

	public void setProcessArea(ProcessArea processArea) {
		this.processArea = processArea;
	}
}
