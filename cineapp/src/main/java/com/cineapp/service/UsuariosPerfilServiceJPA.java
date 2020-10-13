package com.cineapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineapp.model.Usuarioperfil;
import com.cineapp.repository.UsuarioPerfilRepository;
@Service
public class UsuariosPerfilServiceJPA implements IUsuarioPerfilService {

	@Autowired
	private UsuarioPerfilRepository perfilRepo;
	
	
	
	@Override
	public void save(Usuarioperfil usuarioperfil) {
		perfilRepo.save(usuarioperfil);
		
	}

}
