package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.Model;

@Repository
public class ModelDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<Model> getAllModel(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Model> criteria = cb.createQuery(Model.class);
		Collection<Model> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public Model getModelById(long id){
		Model model = em.find(Model.class, id);
		return model;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public Model createModel(Model model){
		em.persist(model);
		return model;
	}
	
	@Transactional
	public void deleteModel(long id) {
		Model model = getModelById(id);

		if (model != null) {
			em.remove(model);
		}
	}
	
	@Transactional
	public Model updateModel(long id, Model newModel){
		Model model = getModelById(id);
		
		model.setName(newModel.getName());
		model.setDescription(newModel.getDescription());
		model.setInitials(newModel.getInitials());
		model.setGenericGoals(newModel.getGenericGoals());
		
		em.merge(model);
		return model;
	}
}
