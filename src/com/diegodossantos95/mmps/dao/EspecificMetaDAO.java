package com.diegodossantos95.mmps.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodossantos95.mmps.model.EspecificMeta;

@Repository
public class EspecificMetaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Collection<EspecificMeta> getAllEspecificMeta(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<EspecificMeta> criteria = cb.createQuery(EspecificMeta.class);
		Collection<EspecificMeta> resultList = em.createQuery(criteria).getResultList();
		return resultList;
	}
	
	public EspecificMeta getEspecificMetaById(long id){
		EspecificMeta especificMeta = em.find(EspecificMeta.class, id);
		return especificMeta;
	}
	
	/*
	 * Transactional methods
	 */
	
	@Transactional
	public EspecificMeta createEspecificMeta(EspecificMeta especificMeta){
		em.persist(especificMeta);
		return especificMeta;
	}
	
	@Transactional
	public void deleteEspecificMeta(long id) {
		EspecificMeta especificMeta = getEspecificMetaById(id);

		if (especificMeta != null) {
			em.remove(especificMeta);
		}
	}
	
	@Transactional
	public EspecificMeta updateEspecificMeta(long id, EspecificMeta newEspecificMeta){
		EspecificMeta especificMeta = getEspecificMetaById(id);
		
		especificMeta.setName(newEspecificMeta.getName());
		especificMeta.setDescription(newEspecificMeta.getDescription());
		especificMeta.setInitials(newEspecificMeta.getInitials());
		
		em.merge(especificMeta);
		return especificMeta;
	}
}
