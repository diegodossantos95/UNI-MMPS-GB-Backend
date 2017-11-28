package com.diegodossantos95.mmps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SpecificGoal {

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
	@JsonIgnoreProperties({"model", "category","maturityLevel", "specificGoals", "genericGoals"})
	private ProcessArea processArea;
	
	@OneToMany(mappedBy="specificGoal")
	@JsonIgnoreProperties({"specificGoal"})
	private List<SpecificPractice> specificPractices;

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

	public ProcessArea getProcessArea() {
		return processArea;
	}

	public void setProcessArea(ProcessArea processArea) {
		this.processArea = processArea;
	}

	public List<SpecificPractice> getSpecificPractices() {
		return specificPractices;
	}

	public void setSpecificPractices(List<SpecificPractice> specificPractices) {
		this.specificPractices = specificPractices;
	}
}
