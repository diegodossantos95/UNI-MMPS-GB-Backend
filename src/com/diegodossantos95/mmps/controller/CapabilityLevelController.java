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

import com.diegodossantos95.mmps.dao.CapabilityLevelDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.CapabilityLevel;

@Controller
@RequestMapping("/capability-level")
public class CapabilityLevelController {

	@Autowired
	private CapabilityLevelDAO capabilityLevelDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<CapabilityLevel> findAll() {
		return capabilityLevelDao.getAllCapabilityLevel();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody CapabilityLevel findById(@PathVariable long id) {
		CapabilityLevel object = capabilityLevelDao.getCapabilityLevelById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody CapabilityLevel create(@RequestBody CapabilityLevel capabilityLevel) {
		return capabilityLevelDao.createCapabilityLevel(capabilityLevel);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		capabilityLevelDao.deleteCapabilityLevel(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CapabilityLevel update(@PathVariable long id, @RequestBody CapabilityLevel capabilityLevel) {
		return capabilityLevelDao.updateCapabilityLevel(id, capabilityLevel);
	}
}
