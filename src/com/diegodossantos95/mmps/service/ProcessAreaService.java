package com.diegodossantos95.mmps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodossantos95.mmps.model.ProcessArea;
import com.diegodossantos95.mmps.model.SpecificGoal;
import com.diegodossantos95.mmps.repository.ProcessAreaRepository;

@Service
public class ProcessAreaService {
	@Autowired
	ProcessAreaRepository repository;
	
	private ProcessArea getProcessAreaById(Long id){
		if (id != null) {
			return repository.findOne(id);
		}
		return null;
	}
	
	public void saveSpecificGoal(SpecificGoal specificGoal){
		ProcessArea processArea = this.getProcessAreaById(specificGoal.getProcessArea().getId());
		processArea.addSpecificGoal(specificGoal);
	}
	
	public void removeSpecificGoal(SpecificGoal specificGoal){
		ProcessArea processArea = this.getProcessAreaById(specificGoal.getProcessArea().getId());
		processArea.removeSpecificGoal(specificGoal);
	}
}
