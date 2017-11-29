package com.diegodossantos95.mmps.controller.processArea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.ProcessArea;
import com.diegodossantos95.mmps.repository.ProcessAreaRepository;

@Component
public class ProcessAreaQuery extends AbstractModelQuery<ProcessArea, ProcessAreaRepository> {

	@Autowired
	public ProcessAreaQuery(ProcessAreaRepository repository) {
		super(repository);
	}
}
