package com.cineapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cineapp.model.Usuario;
import com.cineapp.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private IUsuarioService usuService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@GetMapping("/demo-bcrypt")
	public String pruebaBCrypt() {
	String password = "Acceso123";
	String encriptado=encoder.encode(password);
	System.out.println("PAssword encriptado" + encriptado);
	return "usuario/demo";
	}
	
	
	@GetMapping("/create")
	public  String crear(@ModelAttribute Usuario usuario) {
		return "form/formUsuarios";
	}
	
//	INDEX PAGINADO
	@GetMapping(value = "/listar")
	public String mostrarIndexPaginado(Model model, Pageable page) {
	Page<Usuario> lista = usuService.buscarTodas_page(page);
	model.addAttribute("usuarios", lista);
	System.out.println(lista);
	return "form/listUsuarios";
	}
	
	
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Usuario usuario) {
		System.out.println("Usuario " + usuario);

		return "redirect:/usuarios/listar";
				
		
		
	}
	
	
}
