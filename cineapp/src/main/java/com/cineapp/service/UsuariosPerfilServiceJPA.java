package com.cineapp.service;

import org.springframework.stereotype.Service;

import com.cineapp.model.Usuarioperfil;
import com.cineapp.repository.UsuarioPerfilRepository;
@Service
public class UsuariosPerfilServiceJPA implements IUsuarioPerfilService {

	
	private UsuarioPerfilRepository perfilRepo;
	
	
	
	@Override
	public void sava(Usuarioperfil usuarioperfil) {
		perfilRepo.save(usuarioperfil);
		
	}

}
