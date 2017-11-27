package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.GenericGoal;

@Repository
public class GenericGoalDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<GenericGoal> getAllGenericGoal(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<GenericGoal> criteria = cb.createQuery(GenericGoal.class);
		Collection<GenericGoal> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public GenericGoal getGenericGoalById(long id){
		GenericGoal GenericGoal = em.find(GenericGoal.class, id);
		return GenericGoal;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public GenericGoal createGenericGoal(GenericGoal GenericGoal){
		em.persist(GenericGoal);
		return GenericGoal;
	}
	
	@Transactional
	public void deleteGenericGoal(long id) {
		GenericGoal GenericGoal = getGenericGoalById(id);

		if (GenericGoal != null) {
			em.remove(GenericGoal);
		}
	}
	
	@Transactional
	public GenericGoal updateGenericGoal(long id, GenericGoal newGenericGoal){
		GenericGoal GenericGoal = getGenericGoalById(id);
		
		GenericGoal.setName(newGenericGoal.getName());
		GenericGoal.setDescription(newGenericGoal.getDescription());
		GenericGoal.setInitials(newGenericGoal.getInitials());
		GenericGoal.setProcessArea(newGenericGoal.getProcessArea());
		GenericGoal.setCapabilityLevel(newGenericGoal.getCapabilityLevel());
		
		em.merge(GenericGoal);
		return GenericGoal;
	}
}
