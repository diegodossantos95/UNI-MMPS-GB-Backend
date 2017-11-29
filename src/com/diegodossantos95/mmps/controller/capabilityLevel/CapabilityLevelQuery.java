package com.diegodossantos95.mmps.controller.capabilityLevel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.CapabilityLevel;
import com.diegodossantos95.mmps.repository.CapabilityLevelRepository;

@Component
public class CapabilityLevelQuery extends AbstractModelQuery<CapabilityLevel, CapabilityLevelRepository> {

	@Autowired
	public CapabilityLevelQuery(CapabilityLevelRepository repository) {
		super(repository);
	}
}