package com.diegodossantos95.mmps.controller.capabilityLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.CapabilityLevel;
import com.diegodossantos95.mmps.repository.CapabilityLevelRepository;

@Component
public class CapabilityLevelOperator extends AbstractModelOperator<CapabilityLevel, CapabilityLevelRepository> {
	@Autowired
	public CapabilityLevelOperator(CapabilityLevelRepository repository) {
		super(repository);
	}

	@Override
	protected CapabilityLevel updateFields(CapabilityLevel existingInstance, CapabilityLevel updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setDescription(updatedInstance.getDescription());
		existingInstance.setInitials(updatedInstance.getInitials());
		
		return existingInstance;
	}
}