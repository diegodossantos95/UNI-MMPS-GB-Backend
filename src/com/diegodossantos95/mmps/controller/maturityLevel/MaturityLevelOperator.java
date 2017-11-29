package com.diegodossantos95.mmps.controller.maturityLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.MaturityLevel;
import com.diegodossantos95.mmps.repository.MaturityLevelRepository;

@Component
public class MaturityLevelOperator extends AbstractModelOperator<MaturityLevel, MaturityLevelRepository> {
	@Autowired
	public MaturityLevelOperator(MaturityLevelRepository repository) {
		super(repository);
	}

	@Override
	protected MaturityLevel updateFields(MaturityLevel existingInstance, MaturityLevel updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setDescription(updatedInstance.getDescription());
		existingInstance.setInitials(updatedInstance.getInitials());
		
		return existingInstance;
	}
}
