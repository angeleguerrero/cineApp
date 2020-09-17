package com.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cineapp.model.Pelicula;

@Repository
public interface PeliculasRepositoryQuery extends JpaRepository<Pelicula, Integer> {

	@Query("select p from Pelicula p where p.titulo = ?1")
	Pelicula anyNameMethod(String titulo);
	
}
