package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.specificPractice.SpecificPracticeOperator;
import com.diegodossantos95.mmps.controller.specificPractice.SpecificPracticeQuery;
import com.diegodossantos95.mmps.model.SpecificPractice;

@RestController
@RequestMapping("/specificPractice")
public class SpecificPracticeServlet extends AbstractBaseRestService<SpecificPractice, SpecificPracticeOperator, SpecificPracticeQuery> {

	@Autowired
	public SpecificPracticeServlet(SpecificPracticeOperator operator, SpecificPracticeQuery query) {
		super(operator, query);
	}
}
