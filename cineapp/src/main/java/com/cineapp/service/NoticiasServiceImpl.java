package com.cineapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cineapp.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService {

	
	// Constructor vacio. Unicamente para imprimir un mensaje al crearse una instancia
		public NoticiasServiceImpl() {
			System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
		}
		
		@Override
		public void guardar(Noticia noticia) {
			System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
		}

		@Override
		public List<Noticia> buscarTodos() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Page<Noticia> buscarTodosPage(Pageable page) {
			// TODO Auto-generated method stub
			return null;
		}
	
	
}
