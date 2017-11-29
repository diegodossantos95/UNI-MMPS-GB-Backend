package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.model.ModelOperator;
import com.diegodossantos95.mmps.controller.model.ModelQuery;
import com.diegodossantos95.mmps.model.Model;

@RestController
@RequestMapping("/model")
public class ModelServlet extends AbstractBaseRestService<Model, ModelOperator, ModelQuery> {

	@Autowired
	public ModelServlet(ModelOperator operator, ModelQuery query) {
		super(operator, query);
	}
}