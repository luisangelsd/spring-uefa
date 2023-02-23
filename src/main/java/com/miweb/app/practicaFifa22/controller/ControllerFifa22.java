package com.miweb.app.practicaFifa22.controller;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.miweb.app.practicaFifa22.model.entity.EntityEquipo;
import com.miweb.app.practicaFifa22.model.services.IServiciosFifa22;



@Controller
@RequestMapping({"/",""})
public class ControllerFifa22 {

	
	
	@Autowired
	@Qualifier("serviciosFifa22")
	public IServiciosFifa22 serviciosFifa22;
	
	
	
	//------------------------------------ Vistas
	
	
	@GetMapping({"/"})
	public String vistaListar(Model model) {
		model.addAttribute("titulo", "Equipos:");
		model.addAttribute("entityEquipo", serviciosFifa22.listar());
		return "equipos";
	}
	
	
	//@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping({"agregar-equipo"})
	public String vistaregistrarEquipo( Map<String, Object>model) {
		
		EntityEquipo entityEquipo=new EntityEquipo();	
		model.put("titulo", "Agregar Equipo");
		model.put("entityEquipo", entityEquipo);
		return "agregar-equipo";
	}
	
	
	//@Secured({"ROLE_USER","ROLE_ADMIN"})
	@GetMapping({"editar/{id}"})
	public String cargarVentanaEditar(@PathVariable(name = "id") Long id, Map<String, Object> model) {
		
		if (id!=null && id>0) {
			EntityEquipo entityEquipo=serviciosFifa22.busdar(id);
			model.put("entityEquipo", entityEquipo);
			model.put("titulo", "Editar Equipo");
			serviciosFifa22.busdar(id);

		}else{
			return "redirec:/";
		}
			
		
		return"agregar-equipo";
	}
	
	
	
	
	
	//------------------------------------  Metodos
	
	//@Secured({"ROLE_USER","ROLE_ADMIN"})
	@PostMapping({"agregar-equipo"})
	public String guardarActualizar(@Valid EntityEquipo entityEquipo, BindingResult valid, RedirectAttributes flash) {	
		
		String mensaje;
		
		
		if(valid.hasErrors()) {
			return "/agregar-equipo";
		}
		

		
		if(entityEquipo.getId()!=null && entityEquipo.getId()>0) {
			mensaje="Equipo actualizado";
		}else {
			mensaje="Equipo Guardado";
			}
		
		
		
		flash.addFlashAttribute("success", mensaje);
		serviciosFifa22.guardar(entityEquipo);	
		return "redirect:/";
		
	}
	
	
	
	//@Secured({"ROLE_ADMIN"})
	@GetMapping({"eliminar/{id}"})
	public String eliminar(@PathVariable(value = "id") Long id, RedirectAttributes flash) {
		
		flash.addFlashAttribute("error", "Equipo Eliminado");
		serviciosFifa22.eliminar(id);
		return "redirect:/";
	}
	
	
}
