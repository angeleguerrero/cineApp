package com.cineapp.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cineapp.model.Contacto;
import com.cineapp.service.IPeliculaService;

@Controller
public class ContactoController {

	@Autowired
	IPeliculaService servicePeliculas;
	
	
	@GetMapping("/contacto")
//	Para agregar otro valor a la instancia del model seria como sigue(@ModelAttribute("nombre"), este nombre se agrega en el form en modelAttribute y en el spression laguaje)
	public String mostrarFormulario(@ModelAttribute Contacto contacto, Model model) {
		
		model.addAttribute("generos", servicePeliculas.buscarGeneros());
		model.addAttribute("tipoNotificaciones", tipoNotificaciones());
		
		return "form/formContacto";
	}
	
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute Contacto contacto) {
//		model.addAttribute("generos", servicePeliculas.buscarGeneros());
		System.out.println(contacto);
		return "redirect:/contacto";
	}
	
	private List<String>tipoNotificaciones(){
		List<String>tiposnotificaciones = new LinkedList<>();
		tiposnotificaciones.add("Estrenos");
		tiposnotificaciones.add("Promociones");
		tiposnotificaciones.add("Noticias");
		tiposnotificaciones.add("Preventa");
		
		return tiposnotificaciones;
		
	}
	
	
}
