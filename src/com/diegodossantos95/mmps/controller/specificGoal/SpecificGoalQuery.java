package com.diegodossantos95.mmps.controller.specificGoal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.SpecificGoal;
import com.diegodossantos95.mmps.repository.SpecificGoalRepository;

@Component
public class SpecificGoalQuery extends AbstractModelQuery<SpecificGoal, SpecificGoalRepository> {

	@Autowired
	public SpecificGoalQuery(SpecificGoalRepository repository) {
		super(repository);
	}
}
