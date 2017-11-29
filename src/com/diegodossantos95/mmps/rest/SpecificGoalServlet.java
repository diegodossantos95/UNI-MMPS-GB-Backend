package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.specificGoal.SpecificGoalOperator;
import com.diegodossantos95.mmps.controller.specificGoal.SpecificGoalQuery;
import com.diegodossantos95.mmps.model.SpecificGoal;

@RestController
@RequestMapping("/specificGoal")
public class SpecificGoalServlet extends AbstractBaseRestService<SpecificGoal, SpecificGoalOperator, SpecificGoalQuery> {

	@Autowired
	public SpecificGoalServlet(SpecificGoalOperator operator, SpecificGoalQuery query) {
		super(operator, query);
	}
}
