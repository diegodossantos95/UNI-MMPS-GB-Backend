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

import com.diegodossantos95.mmps.dao.EspecificMetaDAO;
import com.diegodossantos95.mmps.exception.ResourceNotFoundException;
import com.diegodossantos95.mmps.model.EspecificMeta;

@Controller
@RequestMapping("/especific-meta")
public class EspecificMetaController {

	@Autowired
	private EspecificMetaDAO especificMetaDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Collection<EspecificMeta> findAll() {
		return especificMetaDao.getAllEspecificMeta();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody EspecificMeta findById(@PathVariable long id) {
		EspecificMeta object = especificMetaDao.getEspecificMetaById(id);
		if(object == null){
            throw new ResourceNotFoundException(); 
		}
		return object;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody EspecificMeta create(@RequestBody EspecificMeta especificMeta) {
		return especificMetaDao.createEspecificMeta(especificMeta);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable long id) {
		especificMetaDao.deleteEspecificMeta(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody EspecificMeta update(@PathVariable long id, @RequestBody EspecificMeta especificMeta) {
		return especificMetaDao.updateEspecificMeta(id, especificMeta);
	}
}
