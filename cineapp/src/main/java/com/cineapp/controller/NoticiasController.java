package com.cineapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cineapp.model.Noticia;

@Controller
@RequestMapping("/noticias")
public class NoticiasController {

	@GetMapping(value = "/create")
	public String crear() {
		return "form/formNoticia";
	}
	
	@PostMapping(value = "/save")
	public String salvar(@RequestParam("titulo") String titulo, @RequestParam("estatus") String estatus, @RequestParam("detalle") String detalle ) {
		System.out.println("Titulo: "+titulo + "Estado: " +estatus +"Detalle: " +detalle);
		
		Noticia noticias = new  Noticia();
		noticias.setTitulo(titulo);
		noticias.setEstatus(estatus);
		noticias.setDetalle(detalle); 
		
		
		//Salvar en BBDD
		System.out.println(noticias);
		
		
		return "form/formNoticia";
	}
	
}
