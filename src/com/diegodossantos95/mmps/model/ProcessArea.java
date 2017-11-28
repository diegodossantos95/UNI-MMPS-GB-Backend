package com.diegodossantos95.mmps.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ProcessArea {

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
	@JsonIgnoreProperties({"processAreas"})
	private Model model;
	
	@ManyToOne
	@JoinColumn
	private Category category;
	
	@ManyToOne
	@JoinColumn
	private MaturityLevel maturityLevel;
	
	@OneToMany(mappedBy="processArea", fetch=FetchType.EAGER)
	@JsonIgnoreProperties({"processArea"})
	private List<SpecificGoal> specificGoals;

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
	
	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public MaturityLevel getMaturityLevel() {
		return maturityLevel;
	}

	public void setMaturityLevel(MaturityLevel maturityLevel) {
		this.maturityLevel = maturityLevel;
	}

	public List<SpecificGoal> getSpecificGoals() {
		return specificGoals;
	}

	public void setSpecificGoals(List<SpecificGoal> specificGoals) {
		this.specificGoals = specificGoals;
	}
}
