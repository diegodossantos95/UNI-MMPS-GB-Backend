package com.diegodossantos95.mmps.controller.workProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.model.WorkProduct;
import com.diegodossantos95.mmps.repository.WorkProductRepository;
import com.diegodossantos95.mmps.service.SpecificPracticeService;

@Component
public class WorkProductOperator extends AbstractModelOperator<WorkProduct, WorkProductRepository> {
	
	@Autowired
	SpecificPracticeService specificPracticeService;
	
	@Autowired
	public WorkProductOperator(WorkProductRepository repository) {
		super(repository);
	}

	@Override
	protected WorkProduct updateFields(WorkProduct existingInstance, WorkProduct updatedInstance) {
		existingInstance.setName(updatedInstance.getName());
		existingInstance.setLink(updatedInstance.getLink());
		existingInstance.setSpecificPractices(updatedInstance.getSpecificPractices());
		
		return existingInstance;
	}
	
	@Override
	protected WorkProduct afterCreate(WorkProduct instance) {
		specificPracticeService.saveWorkProduct(instance);
		return super.afterCreate(instance);
	}
}
