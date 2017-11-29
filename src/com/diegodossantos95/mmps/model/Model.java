package com.diegodossantos95.mmps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Model extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String initials;
	
	@OneToMany(mappedBy="model")
	@JsonIgnoreProperties({"model"})
	private List<ProcessArea> processAreas;
	
	@OneToMany(mappedBy="model")
	@JsonIgnoreProperties({"model"})
	private List<GenericGoal> genericGoals;

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
	
	public void addProcessArea(ProcessArea processArea){
		this.processAreas.add(processArea);
	}
	
	public void removeProcessArea(ProcessArea processArea){
		this.processAreas.remove(processArea);
	}
	
	public List<GenericGoal> getGenericGoals() {
		return genericGoals;
	}

	public void setGenericGoals(List<GenericGoal> genericGoals) {
		this.genericGoals = genericGoals;
	}
	
	public void addGenericGoal(GenericGoal genericGoal){
		this.genericGoals.add(genericGoal);
	}
	
	public void removeGenericGoal(GenericGoal genericGoal){
		this.genericGoals.remove(genericGoal);
	}
}
