package com.diegodossantos95.mmps.controller.maturityLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.MaturityLevel;
import com.diegodossantos95.mmps.repository.MaturityLevelRepository;

@Component
public class MaturityLevelQuery extends AbstractModelQuery<MaturityLevel, MaturityLevelRepository> {

	@Autowired
	public MaturityLevelQuery(MaturityLevelRepository repository) {
		super(repository);
	}
}
