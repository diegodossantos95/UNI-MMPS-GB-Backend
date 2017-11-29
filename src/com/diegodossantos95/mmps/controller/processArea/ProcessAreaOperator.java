package com.diegodossantos95.mmps.controller.processArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.ProcessArea;
import com.diegodossantos95.mmps.repository.ProcessAreaRepository;
import com.diegodossantos95.mmps.service.ModelService;

@Component
public class ProcessAreaOperator extends AbstractModelOperator<ProcessArea, ProcessAreaRepository> {

	@Autowired
	ModelService modelService;
	
	@Autowired
	public ProcessAreaOperator(ProcessAreaRepository repository) {
		super(repository);
	}

	@Override
	protected ProcessArea updateFields(ProcessArea existingInstance, ProcessArea updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setDescription(updatedInstance.getDescription());
		existingInstance.setInitials(updatedInstance.getInitials());
		existingInstance.setCategory(updatedInstance.getCategory());
		existingInstance.setMaturityLevel(updatedInstance.getMaturityLevel());
		existingInstance.setSpecificGoals(updatedInstance.getSpecificGoals());
		
		modelService.removeProcessArea(existingInstance);
		existingInstance.setModel(updatedInstance.getModel());
		modelService.saveProcessArea(existingInstance);
		
		return existingInstance;
	}
	
	@Override
	protected ProcessArea afterCreate(ProcessArea instance) {
		modelService.saveProcessArea(instance);
		return super.afterCreate(instance);
	}
	
	@Override
	protected void afterDelete(ProcessArea instance) {
		modelService.removeProcessArea(instance);
		super.afterDelete(instance);
	}
}
