package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.MaturityLevel;

@Repository
public class MaturityLevelDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<MaturityLevel> getAllMaturityLevel(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MaturityLevel> criteria = cb.createQuery(MaturityLevel.class);
		Collection<MaturityLevel> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public MaturityLevel getMaturityLevelById(long id){
		MaturityLevel maturityLevel = em.find(MaturityLevel.class, id);
		return maturityLevel;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public MaturityLevel createMaturityLevel(MaturityLevel maturityLevel){
		em.persist(maturityLevel);
		return maturityLevel;
	}
	
	@Transactional
	public void deleteMaturityLevel(long id) {
		MaturityLevel maturityLevel = getMaturityLevelById(id);

		if (maturityLevel != null) {
			em.remove(maturityLevel);
		}
	}
	
	@Transactional
	public MaturityLevel updateMaturityLevel(long id, MaturityLevel newMaturityLevel){
		MaturityLevel maturityLevel = getMaturityLevelById(id);
		
		maturityLevel.setName(newMaturityLevel.getName());
		maturityLevel.setDescription(newMaturityLevel.getDescription());
		maturityLevel.setInitials(newMaturityLevel.getInitials());
		
		em.merge(maturityLevel);
		return maturityLevel;
	}
}
