package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.genericGoal.GenericGoalOperator;
import com.diegodossantos95.mmps.controller.genericGoal.GenericGoalQuery;
import com.diegodossantos95.mmps.model.GenericGoal;

@RestController
@RequestMapping("/genericGoal")
public class GenericGoalServlet extends AbstractBaseRestService<GenericGoal, GenericGoalOperator, GenericGoalQuery> {

	@Autowired
	public GenericGoalServlet(GenericGoalOperator operator, GenericGoalQuery query) {
		super(operator, query);
	}
}
