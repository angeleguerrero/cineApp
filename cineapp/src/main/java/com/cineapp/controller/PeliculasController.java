package com.cineapp.controller;

import javax.xml.ws.BindingType;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cineapp.model.Pelicula;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@GetMapping(value = "/create")
	public String crear() {
		return "form/formPeliculas";
	}
	
	@PostMapping("/save")
	public String guardar(Pelicula pelicula , BindingResult result) {
		System.out.println("Salvando OBJ Pelicula" + pelicula);
		return "form/formPeliculas";
	}
	
}
