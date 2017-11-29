package com.diegodossantos95.mmps.controller.specificPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.SpecificPractice;
import com.diegodossantos95.mmps.repository.SpecificPracticeRepository;
import com.diegodossantos95.mmps.service.SpecificGoalService;

@Component
public class SpecificPracticeOperator extends AbstractModelOperator<SpecificPractice, SpecificPracticeRepository> {
	
	@Autowired
	SpecificGoalService specificGoalService;
	
	@Autowired
	public SpecificPracticeOperator(SpecificPracticeRepository repository) {
		super(repository);
	}

	@Override
	protected SpecificPractice updateFields(SpecificPractice existingInstance, SpecificPractice updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setDescription(updatedInstance.getDescription());
		existingInstance.setInitials(updatedInstance.getInitials());
		
		specificGoalService.removeSpecificPractice(existingInstance);
		existingInstance.setSpecificGoal(updatedInstance.getSpecificGoal());
		specificGoalService.saveSpecificPractice(existingInstance);
		
		return existingInstance;
	}
	
	@Override
	protected void afterDelete(SpecificPractice instance) {
		specificGoalService.removeSpecificPractice(instance);
		super.afterDelete(instance);
	}

	@Override
	protected SpecificPractice afterCreate(SpecificPractice instance) {
		specificGoalService.saveSpecificPractice(instance);
		return super.afterCreate(instance);
	}
}
