package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.processArea.ProcessAreaOperator;
import com.diegodossantos95.mmps.controller.processArea.ProcessAreaQuery;
import com.diegodossantos95.mmps.model.ProcessArea;

@RestController
@RequestMapping("/processArea")
public class ProcessAreaServlet extends AbstractBaseRestService<ProcessArea, ProcessAreaOperator, ProcessAreaQuery> {

	@Autowired
	public ProcessAreaServlet(ProcessAreaOperator operator, ProcessAreaQuery query) {
		super(operator, query);
	}
}

