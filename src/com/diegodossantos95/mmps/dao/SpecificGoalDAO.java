package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.SpecificGoal;

@Repository
public class SpecificGoalDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<SpecificGoal> getAllSpecificGoal(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<SpecificGoal> criteria = cb.createQuery(SpecificGoal.class);
		Collection<SpecificGoal> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public SpecificGoal getSpecificGoalById(long id){
		SpecificGoal SpecificGoal = em.find(SpecificGoal.class, id);
		return SpecificGoal;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public SpecificGoal createSpecificGoal(SpecificGoal SpecificGoal){
		em.persist(SpecificGoal);
		return SpecificGoal;
	}
	
	@Transactional
	public void deleteSpecificGoal(long id) {
		SpecificGoal SpecificGoal = getSpecificGoalById(id);

		if (SpecificGoal != null) {
			em.remove(SpecificGoal);
		}
	}
	
	@Transactional
	public SpecificGoal updateSpecificGoal(long id, SpecificGoal newSpecificGoal){
		SpecificGoal SpecificGoal = getSpecificGoalById(id);
		
		SpecificGoal.setName(newSpecificGoal.getName());
		SpecificGoal.setDescription(newSpecificGoal.getDescription());
		SpecificGoal.setInitials(newSpecificGoal.getInitials());
		SpecificGoal.setProcessArea(newSpecificGoal.getProcessArea());
		
		em.merge(SpecificGoal);
		return SpecificGoal;
	}
}
