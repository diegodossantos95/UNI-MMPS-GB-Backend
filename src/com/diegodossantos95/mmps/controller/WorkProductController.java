package com.diegodossantos95.mmps.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.diegodossantos95.mmps.dao.WorkProductDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.WorkProduct;

@Controller
@RequestMapping("/work-product")
public class WorkProductController {
	@Autowired
	private WorkProductDAO WorkProductDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<WorkProduct> findAll() {
		return WorkProductDAO.getAllWorkProduct();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody WorkProduct findById(@PathVariable long id) {
		WorkProduct object = WorkProductDAO.getWorkProductById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody WorkProduct create(@RequestBody WorkProduct WorkProduct) {
		return WorkProductDAO.createWorkProduct(WorkProduct);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		WorkProductDAO.deleteWorkProduct(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody WorkProduct update(@PathVariable long id, @RequestBody WorkProduct WorkProduct) {
		return WorkProductDAO.updateWorkProduct(id, WorkProduct);
	}
}
