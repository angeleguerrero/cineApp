package com.cineapp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.cineapp.model.Usuario;

public interface IUsuarioService {
void save(Usuario usuario);
Page<Usuario> buscarTodas_page(Pageable page);

	
}
