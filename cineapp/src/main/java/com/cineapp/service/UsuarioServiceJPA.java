package com.cineapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cineapp.model.Usuario;
import com.cineapp.repository.UsuariosRepository;


@Service
public class UsuarioServiceJPA implements IUsuarioService {
	
	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void save(Usuario usuario) {
		usuariosRepo.save(usuario);
		
	}

	@Override
	public Page<Usuario> buscarTodas_page(Pageable page) {
		
		return usuariosRepo.findAll(page);
	}



}
