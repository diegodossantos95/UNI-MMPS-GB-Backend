package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.CapabilityLevel;

@Repository
public class CapabilityLevelDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<CapabilityLevel> getAllCapabilityLevel(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CapabilityLevel> criteria = cb.createQuery(CapabilityLevel.class);
		Collection<CapabilityLevel> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public CapabilityLevel getCapabilityLevelById(long id){
		CapabilityLevel capabilityLevel = em.find(CapabilityLevel.class, id);
		return capabilityLevel;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public CapabilityLevel createCapabilityLevel(CapabilityLevel capabilityLevel){
		em.persist(capabilityLevel);
		return capabilityLevel;
	}
	
	@Transactional
	public void deleteCapabilityLevel(long id) {
		CapabilityLevel capabilityLevel = getCapabilityLevelById(id);

		if (capabilityLevel != null) {
			em.remove(capabilityLevel);
		}
	}
	
	@Transactional
	public CapabilityLevel updateCapabilityLevel(long id, CapabilityLevel newCapabilityLevel){
		CapabilityLevel capabilityLevel = getCapabilityLevelById(id);
		
		capabilityLevel.setName(newCapabilityLevel.getName());
		capabilityLevel.setDescription(newCapabilityLevel.getDescription());
		capabilityLevel.setInitials(newCapabilityLevel.getInitials());
		
		em.merge(capabilityLevel);
		return capabilityLevel;
	}
}
