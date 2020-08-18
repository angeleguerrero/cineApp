package com.cineapp.service;

import java.util.List;



import com.cineapp.model.Pelicula;

public interface IPeliculaService {

	void insertar(Pelicula pelicula);
	List<Pelicula>buscarTodas();
	Pelicula buscarPorId(int IdPelicula);
	
}
