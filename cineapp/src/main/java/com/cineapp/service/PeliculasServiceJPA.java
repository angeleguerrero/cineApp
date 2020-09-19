package com.cineapp.service;



import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cineapp.model.Pelicula;
import com.cineapp.repository.PeliculasRepository;


@Service
@Primary
public class PeliculasServiceJPA implements IPeliculaService {
	@Autowired
	private PeliculasRepository peliculasRepo;

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
		
	}

	@Override
	public List<Pelicula> buscarTodas() {
		
		return peliculasRepo.findAll();
		
	}

	@Override
	public Pelicula buscarPorId(int IdPelicula) {
		Optional<Pelicula>optionalbuscar= peliculasRepo.findById(IdPelicula);
		if ( optionalbuscar.isPresent()) {
		return optionalbuscar.get();	
			
		}
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
		List<String>generos = new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasica");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica");
		generos.add("Ciancia Ficcion");
		generos.add("test");
		
		return generos ;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
		
	}

	@Override
	public Page<Pelicula> buscarTodas_page(Pageable page) {
		
		return peliculasRepo.findAll(page);
	}

	

	

}
