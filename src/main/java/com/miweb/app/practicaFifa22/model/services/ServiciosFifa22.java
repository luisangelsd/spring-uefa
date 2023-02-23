package com.miweb.app.practicaFifa22.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miweb.app.practicaFifa22.model.dao.IDaoFifa22;
import com.miweb.app.practicaFifa22.model.entity.EntityEquipo;

@Service("serviciosFifa22")
public class ServiciosFifa22 implements IServiciosFifa22{
	
	@Autowired
	private IDaoFifa22 iDaoFifa22;

	@Override
	public List<EntityEquipo> listar() {
		
		return iDaoFifa22.listar();
	}

	@Override
	public void guardar(EntityEquipo entityEquipo) {
		iDaoFifa22.guardar(entityEquipo);
		
	}

	@Override
	public EntityEquipo busdar(Long id) {
	
		return iDaoFifa22.busdar(id);
	}

	@Override
	public void eliminar(Long id) {
		iDaoFifa22.eliminar(id);
		
	}

}
