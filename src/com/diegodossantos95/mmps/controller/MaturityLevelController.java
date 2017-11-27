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

import com.diegodossantos95.mmps.dao.MaturityLevelDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.MaturityLevel;

@Controller
@RequestMapping("/maturityLevel")
public class MaturityLevelController {

	@Autowired
	private MaturityLevelDAO maturitylevelDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<MaturityLevel> findAll() {
		return maturitylevelDao.getAllMaturityLevel();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody MaturityLevel findById(@PathVariable long id) {
		MaturityLevel object = maturitylevelDao.getMaturityLevelById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody MaturityLevel create(@RequestBody MaturityLevel maturityLevel) {
		return maturitylevelDao.createMaturityLevel(maturityLevel);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		maturitylevelDao.deleteMaturityLevel(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody MaturityLevel update(@PathVariable long id, @RequestBody MaturityLevel maturityLevel) {
		return maturitylevelDao.updateMaturityLevel(id, maturityLevel);
	}
}
