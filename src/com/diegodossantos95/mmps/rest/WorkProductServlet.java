package com.diegodossantos95.mmps.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegodossantos95.mmps.controller.workProduct.WorkProductOperator;
import com.diegodossantos95.mmps.controller.workProduct.WorkProductQuery;
import com.diegodossantos95.mmps.model.WorkProduct;

@RestController
@RequestMapping("/workProduct")
public class WorkProductServlet extends AbstractBaseRestService<WorkProduct, WorkProductOperator, WorkProductQuery> {

	@Autowired
	public WorkProductServlet(WorkProductOperator operator, WorkProductQuery query) {
		super(operator, query);
	}
}

