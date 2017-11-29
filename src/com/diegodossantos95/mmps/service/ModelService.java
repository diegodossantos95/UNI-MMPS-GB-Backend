package com.diegodossantos95.mmps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodossantos95.mmps.model.GenericGoal;
import com.diegodossantos95.mmps.model.Model;
import com.diegodossantos95.mmps.model.ProcessArea;
import com.diegodossantos95.mmps.repository.ModelRepository;

@Service
public class ModelService {
	@Autowired
	ModelRepository repository;
	
	private Model getModelById(Long id){
		if (id != null) {
			return repository.findOne(id);
		}
		return null;
	}
	
	public void saveGenericGoal(GenericGoal genericGoal){
		Model model = this.getModelById(genericGoal.getModel().getId());
		model.addGenericGoal(genericGoal);
	}
	
	public void removeGenericGoal(GenericGoal genericGoal){
		Model model = this.getModelById(genericGoal.getModel().getId());
		model.removeGenericGoal(genericGoal);
	}
	
	public void saveProcessArea(ProcessArea processArea){
		Model model = this.getModelById(processArea.getModel().getId());
		model.addProcessArea(processArea);
	}
	
	public void removeProcessArea(ProcessArea processArea){
		Model model = this.getModelById(processArea.getModel().getId());
		model.removeProcessArea(processArea);
	}
}
