package com.diegodossantos95.mmps.controller.specificPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.SpecificPractice;
import com.diegodossantos95.mmps.repository.SpecificPracticeRepository;

@Component
public class SpecificPracticeQuery extends AbstractModelQuery<SpecificPractice, SpecificPracticeRepository> {

	@Autowired
	public SpecificPracticeQuery(SpecificPracticeRepository repository) {
		super(repository);
	}
}
