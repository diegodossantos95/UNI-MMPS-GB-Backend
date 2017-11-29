package com.diegodossantos95.mmps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class WorkProduct extends AbstractModel {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String link;

	@ManyToMany
	@JoinTable
	@JsonIgnoreProperties({"specificGoal", "workProducts"})
	private List<SpecificPractice> specificPractices;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<SpecificPractice> getSpecificPractices() {
		return specificPractices;
	}

	public void setSpecificPractices(List<SpecificPractice> specificPractices) {
		this.specificPractices = specificPractices;
	}
}
