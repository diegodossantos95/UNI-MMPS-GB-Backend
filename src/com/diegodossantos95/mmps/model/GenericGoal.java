package com.diegodossantos95.mmps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GenericGoal extends AbstractModel {
	private static final long serialVersionUID = 1L;

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
	@JsonIgnoreProperties({"genericGoals"})
	private Model model;

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

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
