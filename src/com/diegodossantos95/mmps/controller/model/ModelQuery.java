package com.diegodossantos95.mmps.controller.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.Model;
import com.diegodossantos95.mmps.repository.ModelRepository;

@Component
public class ModelQuery extends AbstractModelQuery<Model, ModelRepository> {

	@Autowired
	public ModelQuery(ModelRepository repository) {
		super(repository);
	}
}
