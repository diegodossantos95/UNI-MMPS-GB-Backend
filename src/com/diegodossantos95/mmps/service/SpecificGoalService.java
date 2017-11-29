package com.diegodossantos95.mmps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodossantos95.mmps.model.SpecificGoal;
import com.diegodossantos95.mmps.model.SpecificPractice;
import com.diegodossantos95.mmps.repository.SpecificGoalRepository;

@Service
public class SpecificGoalService {
	@Autowired
	SpecificGoalRepository repository;
	
	private SpecificGoal getSpecificGoalById(Long id){
		if (id != null) {
			return repository.findOne(id);
		}
		return null;
	}
	
	public void saveSpecificPractice(SpecificPractice specificPractice){
		SpecificGoal specificGoal = this.getSpecificGoalById(specificPractice.getSpecificGoal().getId());
		specificGoal.addSpecificPractice(specificPractice);
	}
}
