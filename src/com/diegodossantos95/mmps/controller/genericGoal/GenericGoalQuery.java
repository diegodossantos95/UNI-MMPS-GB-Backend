package com.diegodossantos95.mmps.controller.genericGoal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.GenericGoal;
import com.diegodossantos95.mmps.repository.GenericGoalRepository;

@Component
public class GenericGoalQuery extends AbstractModelQuery<GenericGoal, GenericGoalRepository> {

	@Autowired
	public GenericGoalQuery(GenericGoalRepository repository) {
		super(repository);
	}
}
