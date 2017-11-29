package com.diegodossantos95.mmps.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.Model;
import com.diegodossantos95.mmps.repository.ModelRepository;

@Component
public class ModelOperator extends AbstractModelOperator<Model, ModelRepository> {
	@Autowired
	public ModelOperator(ModelRepository repository) {
		super(repository);
	}

	@Override
	protected Model updateFields(Model existingInstance, Model updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setDescription(updatedInstance.getDescription());
		existingInstance.setInitials(updatedInstance.getInitials());
		
		return existingInstance;
	}
}