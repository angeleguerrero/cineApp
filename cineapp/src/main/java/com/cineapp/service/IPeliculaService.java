package com.cineapp.service;


import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cineapp.model.Pelicula;

public interface IPeliculaService {

	void insertar(Pelicula pelicula);
	List<Pelicula>buscarTodas();
	Pelicula buscarPorId(int IdPelicula);
	List<String>buscarGeneros();
	void eliminar (int idPelicula);
	 Page<Pelicula> buscarTodas_page(Pageable page);
	 
	// Con este metodo traemos las peliculas Activas. Para formar el select de Peliculas del FORM de nuevo Horario.
	    List<Pelicula> buscarActivas();	
		List<Pelicula> buscarPorFecha(Date fecha);
		Page<Pelicula> buscarTodas(Pageable page);	
		
}