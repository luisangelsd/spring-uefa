package com.miweb.app.practicaFifa22.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ControllerLogin {
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false)String error,
						@RequestParam(value = "logout", required = false)String errorLogout, Model model,Principal principal, RedirectAttributes flash) {
		
		if (principal!=null) {	
			flash.addFlashAttribute("success","¡Ya has iniciado sesión antes!");
			return "redirect:/";
		}
		
		
		/*
		 * Puedes validar desde aquí o puedes validar desde los Handler
		 * 
		if (error!=null) {
			model.addAttribute("error","Usuario y/o contraseña incorrectas");
		}
		
		
		if(errorLogout!=null) {
			model.addAttribute("success","Sesión cerrada");
		}
		*/
		
		return "login";
	}
	
	
	@GetMapping("/mi-cuenta")
	public String vistaMiPerfil() {
		
		return "mi-cuenta";
	}

}
