package com.diegodossantos95.mmps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodossantos95.mmps.model.SpecificPractice;
import com.diegodossantos95.mmps.model.WorkProduct;
import com.diegodossantos95.mmps.repository.SpecificPracticeRepository;

@Service
public class SpecificPracticeService {
	@Autowired
	SpecificPracticeRepository repository;
	
	private SpecificPractice getSpecificPracticeById(Long id){
		if (id != null) {
			return repository.findOne(id);
		}
		return null;
	}
	
	public void saveWorkProduct(WorkProduct workProduct){
		List<SpecificPractice> specificPractices = workProduct.getSpecificPractices();
		
		for(SpecificPractice specificPractice: specificPractices){
			SpecificPractice specificPracticeDB = this.getSpecificPracticeById(specificPractice.getId());
			specificPracticeDB.addWorkProduct(workProduct);
		}
	}
	
	public void removeWorkProduct(WorkProduct workProduct){
		List<SpecificPractice> specificPractices = workProduct.getSpecificPractices();
		
		for(SpecificPractice specificPractice: specificPractices){
			SpecificPractice specificPracticeDB = this.getSpecificPracticeById(specificPractice.getId());
			specificPracticeDB.removeWorkProduct(workProduct);
		}
	}
}
