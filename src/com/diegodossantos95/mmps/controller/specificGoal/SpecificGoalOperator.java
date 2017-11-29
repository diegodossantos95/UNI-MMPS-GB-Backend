package com.diegodossantos95.mmps.controller.specificGoal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.SpecificGoal;
import com.diegodossantos95.mmps.repository.SpecificGoalRepository;
import com.diegodossantos95.mmps.service.ProcessAreaService;

@Component
public class SpecificGoalOperator extends AbstractModelOperator<SpecificGoal, SpecificGoalRepository> {
	@Autowired
	ProcessAreaService processAreaService;
	
	@Autowired
	public SpecificGoalOperator(SpecificGoalRepository repository) {
		super(repository);
	}

	@Override
	protected SpecificGoal updateFields(SpecificGoal existingInstance, SpecificGoal updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setDescription(updatedInstance.getDescription());
		existingInstance.setInitials(updatedInstance.getInitials());
		existingInstance.setProcessArea(updatedInstance.getProcessArea());
		
		return existingInstance;
	}
	
	@Override
	protected SpecificGoal afterCreate(SpecificGoal instance) {
		processAreaService.saveSpecificGoal(instance);
		return super.afterCreate(instance);
	}
}
