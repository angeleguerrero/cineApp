package com.cineapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	
	
	@GetMapping(value = "/listar")
	public String mostrarIndex(Model model) {
		List<Noticia> listaNoticias = serviceNoticias.buscarTodos();
		model.addAttribute("noticias", listaNoticias);
		return "form/listNoticias";
	}
	
	
	
	
	
	@PostMapping(value = "/save")
	
	public String salvar(Noticia noticias) {

		serviceNoticias.guardar(noticias);
		//Salvar en BBDD
		System.out.println(noticias);
		
		
//		return "form/formContacto";
		return "form/formNoticia";
	}
	
	
	
	
	
	
}
