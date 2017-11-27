package com.diegodossantos95.mmps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class SpecificPractice {

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
	private SpecificGoal specificGoal;
	
	@ManyToMany(mappedBy="specificPractices")
	@JsonIgnoreProperties({"specificPractices"})
	private List<WorkProduct> workProducts;
	
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

	public SpecificGoal getSpecificGoal() {
		return specificGoal;
	}

	public void setSpecificGoal(SpecificGoal specificGoal) {
		this.specificGoal = specificGoal;
	}
}
