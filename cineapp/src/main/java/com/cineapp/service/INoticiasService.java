package com.cineapp.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cineapp.model.Noticia;


public interface INoticiasService {

	public void guardar(Noticia noticia) ;
	List<Noticia> buscarTodos();
	Page<Noticia> buscarTodosPage(Pageable page);
	
}
