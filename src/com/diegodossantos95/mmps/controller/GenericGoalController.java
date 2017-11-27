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

import com.diegodossantos95.mmps.dao.GenericGoalDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.GenericGoal;

@Controller
@RequestMapping("/genericGoal")
public class GenericGoalController {

	@Autowired
	private GenericGoalDAO genericGoalDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<GenericGoal> findAll() {
		return genericGoalDAO.getAllGenericGoal();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody GenericGoal findById(@PathVariable long id) {
		GenericGoal object = genericGoalDAO.getGenericGoalById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody GenericGoal create(@RequestBody GenericGoal genericGoal) {
		return genericGoalDAO.createGenericGoal(genericGoal);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		genericGoalDAO.deleteGenericGoal(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody GenericGoal update(@PathVariable long id, @RequestBody GenericGoal genericMeta) {
		return genericGoalDAO.updateGenericGoal(id, genericMeta);
	}
}
