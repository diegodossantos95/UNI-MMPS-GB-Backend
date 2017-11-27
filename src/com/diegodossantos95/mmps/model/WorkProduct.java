package com.diegodossantos95.mmps.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class WorkProduct {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String link;

	@ManyToMany
    @JoinTable
	private Set<SpecificGoal> specificGoals;
	
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<SpecificGoal> getSpecificGoals() {
		return specificGoals;
	}

	public void setSpecificGoals(Set<SpecificGoal> specificGoals) {
		this.specificGoals = specificGoals;
	}
}
