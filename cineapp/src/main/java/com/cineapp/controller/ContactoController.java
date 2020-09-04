package com.cineapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

	@GetMapping("/contacto")
	public String mostrarFormulario() {
		
		return "views/formContacto";
	}
	
	
	
}
