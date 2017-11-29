package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.capabilityLevel.CapabilityLevelOperator;
import com.diegodossantos95.mmps.controller.capabilityLevel.CapabilityLevelQuery;
import com.diegodossantos95.mmps.model.CapabilityLevel;

@RestController
@RequestMapping("/capabilityLevel")
public class CapabilityLevelServlet extends AbstractBaseRestService<CapabilityLevel, CapabilityLevelOperator, CapabilityLevelQuery> {

	@Autowired
	public CapabilityLevelServlet(CapabilityLevelOperator operator, CapabilityLevelQuery query) {
		super(operator, query);
	}
}