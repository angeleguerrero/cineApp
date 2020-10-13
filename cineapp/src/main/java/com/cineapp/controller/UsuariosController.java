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
import org.springframework.web.bind.annotation.RequestParam;

import com.cineapp.model.Usuario;
import com.cineapp.model.Usuarioperfil;
import com.cineapp.service.IUsuarioPerfilService;
import com.cineapp.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {
	@Autowired
	private IUsuarioService usuService;
	@Autowired
	private IUsuarioPerfilService perService;
	
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
	public String guardar(@ModelAttribute Usuario usuario, @RequestParam ("perfil") String perfil) {
		System.out.println("Usuario: "+ usuario);
		System.out.println("Perfil: " + perfil);
		
		String tmpPass = usuario.getPassword();
		String encriptado = encoder.encode(tmpPass);
		usuario.setPassword(encriptado);
		usuario.setEnabled(1);
		usuService.save(usuario);
		
		Usuarioperfil perfilTmp = new Usuarioperfil();
		perfilTmp.setPerfil(perfil);
		perfilTmp.setUsername(usuario.getUsername());
		System.out.println("Usuario Perfil: " + perfilTmp);
		perService.save(perfilTmp);
		return "redirect:/usuarios/listar";

		
	}
	
	
}
