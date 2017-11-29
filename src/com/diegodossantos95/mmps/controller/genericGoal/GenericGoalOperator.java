package com.diegodossantos95.mmps.controller.genericGoal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.GenericGoal;
import com.diegodossantos95.mmps.repository.GenericGoalRepository;
import com.diegodossantos95.mmps.service.ModelService;

@Component
public class GenericGoalOperator extends AbstractModelOperator<GenericGoal, GenericGoalRepository> {
	@Autowired
	ModelService modelService;
	
	@Autowired
	public GenericGoalOperator(GenericGoalRepository repository) {
		super(repository);
	}

	@Override
	protected GenericGoal updateFields(GenericGoal existingInstance, GenericGoal updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setDescription(updatedInstance.getDescription());
		existingInstance.setInitials(updatedInstance.getInitials());
		existingInstance.setModel(updatedInstance.getModel());
		existingInstance.setCapabilityLevel(updatedInstance.getCapabilityLevel());
		
		return existingInstance;
	}

	@Override
	protected GenericGoal afterCreate(GenericGoal instance) {
		modelService.saveGenericGoal(instance);
		return super.afterCreate(instance);
	}
}