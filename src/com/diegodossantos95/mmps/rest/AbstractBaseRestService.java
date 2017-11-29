package com.diegodossantos95.mmps.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.diegodossantos95.mmps.controller.AbstractModelOperator;
import com.diegodossantos95.mmps.controller.AbstractModelQuery;
import com.diegodossantos95.mmps.model.AbstractModel;
import com.diegodossantos95.mmps.repository.AbstractModelRepository;

public abstract class AbstractBaseRestService<T extends AbstractModel, O extends AbstractModelOperator<T, ? extends AbstractModelRepository<T>>, Q extends AbstractModelQuery<T, ?>> {

	@Autowired
	private Q query;

	@Autowired
	private O operator;

	public AbstractBaseRestService(O operator, Q query) {
		this.query = query;
	}

	@RequestMapping(method = RequestMethod.POST)
	public T create(@RequestBody T instance) {
		return getOperator().create(instance);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public T update(@PathVariable Long id, @RequestBody T instance) {
		return getOperator().update(id, instance);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<T> findAll() {
		return getQuery().findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public T findOne(@PathVariable Long id) {
		return getQuery().findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id) {
		getOperator().delete(id);
		return true;
	}

	public Q getQuery() {
		return query;
	}

	public O getOperator() {
		return operator;
	}
}
