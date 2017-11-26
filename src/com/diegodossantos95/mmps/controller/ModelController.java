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

import com.diegodossantos95.mmps.dao.ModelDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.Model;

@Controller
@RequestMapping("/model")
public class ModelController {

	@Autowired
	private ModelDAO modelDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<Model> findAll() {
		return modelDao.getAllModel();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody Model findById(@PathVariable long id) {
		Model object = modelDao.getModelById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Model create(@RequestBody Model model) {
		return modelDao.createModel(model);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		modelDao.deleteModel(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Model update(@PathVariable long id, @RequestBody Model model) {
		return modelDao.updateModel(id, model);
	}
}
