package com.cineapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cineapp.model.Noticia;
import com.cineapp.service.INoticiasService;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@Autowired
	private INoticiasService serviceNoticias;
	
	@GetMapping(value = "/create")
	public String crear() {
		return "form/formNoticia";
	}
	
	@PostMapping(value = "/save")
	
	public String salvar(Noticia noticias) {

		serviceNoticias.guardar(noticias);
		//Salvar en BBDD
		System.out.println(noticias);
		
		
		return "form/formNoticia";
	}
	
}
