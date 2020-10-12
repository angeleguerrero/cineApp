package com.cineapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cineapp.model.Noticia;
import com.cineapp.repository.NoticiasRepository;
@Service
public class NoticiasServiceJPA implements INoticiasService {
	
	@Autowired
	private NoticiasRepository noticiasRepo;

	@Override
	public void guardar(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Noticia> buscarTodos() {
	
		return noticiasRepo.findAll();
	}

	@Override
	public Page<Noticia> buscarTodosPage(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

}
