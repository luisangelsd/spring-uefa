package com.miweb.app.practicaFifa22.model.dao;


import java.util.List;

import com.miweb.app.practicaFifa22.model.entity.EntityEquipo;

public interface IDaoFifa22 {
	
	public List<EntityEquipo> listar();
	public void guardar(EntityEquipo entityEquipo);
	public EntityEquipo busdar(Long id);
	public void eliminar(Long id);

}
