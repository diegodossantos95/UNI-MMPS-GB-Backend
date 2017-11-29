package com.diegodossantos95.mmps.controller.workProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.WorkProduct;
import com.diegodossantos95.mmps.repository.WorkProductRepository;

@Component
public class WorkProductQuery extends AbstractModelQuery<WorkProduct, WorkProductRepository> {

	@Autowired
	public WorkProductQuery(WorkProductRepository repository) {
		super(repository);
	}
}
