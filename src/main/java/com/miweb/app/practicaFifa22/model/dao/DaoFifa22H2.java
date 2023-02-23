package com.miweb.app.practicaFifa22.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.miweb.app.practicaFifa22.model.entity.EntityEquipo;

@Repository("DaoFifa22H2")
public class DaoFifa22H2 implements IDaoFifa22{
	
	
	@PersistenceContext
	private EntityManager em;
	
	

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<EntityEquipo> listar() {
		return em.createQuery("from EntityEquipo").getResultList();
	}



	@Override
	@Transactional
	public void guardar(EntityEquipo entityEquipo) {
		
		if (entityEquipo.getId()!=null && entityEquipo.getId()>0) {
			em.merge(entityEquipo);	
		}else {
			em.persist(entityEquipo);
			
		}	
	}
	


	@Override
	@Transactional
	public EntityEquipo busdar(Long id) {
		EntityEquipo entityEquipo=em.find(EntityEquipo.class, id);
		return entityEquipo;
	}

	

	@Override
	@Transactional
	public void eliminar(Long id) {	
		EntityEquipo entityEquipo=busdar(id);
		em.remove(entityEquipo);
	}





}
