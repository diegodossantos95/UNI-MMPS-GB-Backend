package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.maturityLevel.MaturityLevelOperator;
import com.diegodossantos95.mmps.controller.maturityLevel.MaturityLevelQuery;
import com.diegodossantos95.mmps.model.MaturityLevel;

@RestController
@RequestMapping("/maturityLevel")
public class MaturityLevelServlet extends AbstractBaseRestService<MaturityLevel, MaturityLevelOperator, MaturityLevelQuery> {

	@Autowired
	public MaturityLevelServlet(MaturityLevelOperator operator, MaturityLevelQuery query) {
		super(operator, query);
	}
}
