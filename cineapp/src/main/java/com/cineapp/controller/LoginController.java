package com.cineapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@GetMapping(value = "/index")
	public String mostrarPrincipalAdmin(Authentication authentication) {
//		Recuperar usuario y mostrar por consola
		System.out.println("UserName: " + authentication.getName());
		
//		Desplegar rol de usuario y desplegar por consola
		
		for (GrantedAuthority rol : authentication.getAuthorities()) {
			System.out.println("Rol: "+ rol.getAuthority() );
			
		}
		
		return "admin";
		
	}
	
	
	
	@GetMapping(value="/logout")
	public String logout(HttpServletRequest request){
	SecurityContextLogoutHandler logoutHandler =
	new SecurityContextLogoutHandler();
	logoutHandler.logout(request, null, null);
	return "redirect:/formLogin";
	}
	
	

}
